package com.want.srm.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.want.srm.dao.AccountDao;
import com.want.srm.dao.IsDeleteDao;
import com.want.srm.dao.LoginTokenDao;
import com.want.srm.dao.RoleUserDao;
import com.want.srm.entity.Account;
import com.want.srm.entity.IsDelete;
import com.want.srm.entity.LoginToken;
import com.want.srm.entity.RoleUserKey;
import com.want.srm.po.Login;
import com.want.srm.po.SsoUser;
import com.want.srm.service.AccountService;
import com.want.srm.service.ICryptoService;
import com.want.srm.service.RedisService;
import com.want.srm.utils.CookieUtil;
import com.want.srm.vo.AccountDto;
import com.want.srm.vo.CommonReturnType;
import com.want.srm.vo.LoginVo;

import net.minidev.json.JSONObject;
	
@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private LoginTokenDao LoginTokenDao;
	
	@Autowired
	private IsDeleteDao isDeleteDao;
	
	@Autowired
	private RoleUserDao roleUserDao;
	
	
	@Autowired
	private ICryptoService cryptoService;
	
	@Autowired
	private MailServiceImpl mailServcie;
	
	@Autowired
	private RedisService redisService;
	
	@Value("${wangwang.loginUrl}")
    private String loginUrl;
	
	@Value(value = "${api.url}")
	private String url;
	
	private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Override
	public Map<String, Object> login(LoginVo loginVo) {
		String userId = loginVo.getUserId();//用户名
		String password = loginVo.getPassword();//密码
		
		Map<String, Object> map = new HashMap<String, Object>();
		logger.info("用户信息 userId:{},password:{}",userId,password);
		
		if(userId.length() > 8) {//供应商账号
			return supplierLogin(loginVo);
		}else {//公司员工账号
			map = empLogin(userId,password);
			String code = (String) map.get("code");
			//账号密码验证通过 生成token，否则直接返回
			if ("200".equals(code)) {
				map = loginToken(loginVo, map);//
				//map.put("userId", cryptoService.getEncryptText(userId));
			} 
			return map;
		}
	}
	
	/**
	 * 
	 * @Title: supplierLogin
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param  参数
	 * @return void 返回类型
	 * @throws
	 */
	public Map<String, Object> supplierLogin(LoginVo loginVo) {
		Account account = accountDao.getOneByAccountId(loginVo.getUserId());
		Map<String, Object> map = new HashMap<String, Object>();
			
			if(null == account) {
				map.put("code", "401");
				map.put("message", "账号不可用！");
				map.put("userName", "");
				return map;
			}
			String password = cryptoService.getDecryptText(account.getPassword());
			if(loginVo.getPassword().equals(password)) {
				map.put("code", "200");
				map.put("userId", splitAccount(loginVo.getUserId()));
				map.put("userName",account.getName());
				map.put("roleId","V01");
				map.put("token",productToken(loginVo));
				map.put("isFirst",account.getStatus());
			}else {
				map.put("code", "401");
				map.put("message", "密码不正确！");
				map.put("userName", "");
			}
		return map;
	}
	/**
	 * 员工登录
	 * @Title: empLogin
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param empId
	 * @param @param password 参数
	 * @return void 返回类型
	 * @throws
	 */
	public Map<String, Object> empLogin(String empId, String password) {
		Map<String, Object> map = new HashMap<String, Object>();

		//发送Ldap用户认证
		String content = this.authenticate(url, empId, password);

		// 返回值 string转换为map方便获取
		Map<String, Object> auth = new HashMap<String, Object>();
		auth = new Gson().fromJson(content, auth.getClass());
		String userName = (String) auth.get("userName");

		if (content != null && content.contains("200")) {
			// 返回成功登录信息
			map.put("code", "200");
			map.put("message", "登录成功！");
			map.put("userName", userName);
		} else if (content != null && content.contains("401")) {
			// 返回成功登录信息
			map.put("code", "401");
			map.put("message", "账号密码验证失败！");
			map.put("userName", "");
		}

		return map;
	}
	
	/**
	 * 通过接口验证登陆
	 * 
	 * @param userId password
	 * @return String
	 */
	public String authenticate(String reqUrl, String userid, String password) {
		// 构建jason参数
		JSONObject jsonParam = new JSONObject();
		jsonParam.put("employeeId", userid);
		jsonParam.put("password", password);

		CloseableHttpClient httpClient = HttpClients.createDefault();
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(300 * 1000).setConnectTimeout(300 * 1000)
				.build();
		HttpPost post = new HttpPost(reqUrl);

		post.setConfig(requestConfig);
		post.setHeader("Content-Type", "application/json;charset=utf-8");
		StringEntity postingString = new StringEntity(jsonParam.toJSONString(), "utf-8");
		post.setEntity(postingString);
		HttpResponse response;
		String content = "";
		try {
			// 调用接口
			response = httpClient.execute(post);
			// 获取返回值
			content = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(content);
		return content;
	}
	
	public Map<String, Object> loginToken (LoginVo loginVo, Map<String, Object> map){
		String empId = loginVo.getUserId();
		try {
			// 根据人员工号获取登陆信息
			RoleUserKey roleUserKey = new RoleUserKey(); 
			roleUserKey.setUserId(loginVo.getUserId());
			//List<RoleUser> roleList = roleUserDao.selectRoleByUserId(roleUserKey);
			//List<AccountVo> accountVos = accountDao.findByAccount(empId);
			//AccountVo accountVo = accountDao.findByAccount(empId);
			List<String> roleList = accountDao.getRolesByAccountId(empId);
			LoginToken loginToken = LoginTokenDao.selectByPrimaryKey(empId);
			
			if(roleList.size() > 0) {
				map.put("userId", loginVo.getUserId());
				map.put("userName",map.get("userName"));
				map.put("token", productToken(loginVo));
				String roleCode = retunRoles(roleList);
				map.put("roleId",roleCode);
				map.put("roleIds",roleList);
			}else {
				map.put("code","401");
				map.put("userName","");
				map.put("userId", "");
				map.put("message","请开通供应商系统权限");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			map.put("code", "401");
			map.put("message", "生成token失败！");
			map.put("loginId", empId);
			map.put("token", "");

		}
		return map;
	}
	
	@Override
	public Map<String, Object> updatePassword(@Valid AccountDto accountDto){
		if(!(accountDto.getPassword().equals(accountDto.getRePassword()))){
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", "E");
			result.put("message", "两次密码不一致");
			return result;//WResultUtil.paramError("两次密码不一致");
			//throw new IllegalArgumentException("两次密码不一致");
		//}else {
		}
			Account accoutParam = new Account();
			accoutParam.setAccount(accountDto.getAccount());
			String password = cryptoService.getEncryptText(accountDto.getPassword());
			accoutParam.setPassword(password);
			accountDao.updatePassword(accoutParam);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("status", "S");
			result.put("message", "修改密码成功");
			return result;//WResultUtil.ok(accoutParam);
		//}
	}

	@Override
	public Account getAccountByToken(String token) {
		return accountDao.getAccountByToken(token);
	}

	@Override
	public Map<String, Object> isDelete(String account) {
		Map<String, Object> result = new HashMap<String, Object>();
		IsDelete isDelete = isDeleteDao.selectByAccount(account);
		if(null != isDelete) {
			result.put("code", "200");
			result.put("delete", 1);
		}else {
			result.put("code", "200");
			result.put("delete", 0);
		}
		return result;
	}
	
	public String retunRoles(List<String> roles) {
		String rolestr = "";
		StringBuffer sb = new StringBuffer();
		for(String roleStr : roles){
			sb.append(roleStr).append(",");
		}
		rolestr = sb.toString().substring(0, sb.length()-1);
		return rolestr;
	}
	
	/**
	 * 账号截取
	 * @Title: splitAccount
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param accountStr
	 * @param @return 参数
	 * @return String 返回类型
	 * @throws
	 */
	private String splitAccount(String accountStr) {
		String acoutStr = accountStr.substring(1, 9);
		//acoutStr = "00"+acoutStr;
		return accountStr;
	}
	
	private String productToken(LoginVo loginVo) {
		LoginToken loginToken = LoginTokenDao.selectByPrimaryKey(loginVo.getUserId());
		String token = "";
		if(loginToken != null) {
			token = loginToken.getToken();
			LoginToken loginTokenParam = new LoginToken();
			loginTokenParam.setAccountId(loginVo.getUserId());
			loginTokenParam.setDeadline(getAfterDate());
			LoginTokenDao.updateByPrimaryKeySelective(loginTokenParam);
		}else {
			token = UUID.randomUUID().toString().replaceAll("-", "");
			loginToken = new LoginToken();
			loginToken.setToken(token);
			loginToken.setAccountId(loginVo.getUserId());
			loginToken.setCreateDate(new Date());
			loginToken.setDeadline(getAfterDate());
			loginToken.setLoginState(1);//登录
			LoginTokenDao.insertSelective(loginToken);
		}
		return token;
	}
	
	public Date getAfterDate() {
		return new Date(System.currentTimeMillis() + 60 * 60 * 1000);
	}

	@Override
	public CommonReturnType resetPassword(Map<String, String> map) {
		List<Account> accountList=accountDao.getAccountByParams(map);
		if (accountList ==null ||accountList.size() !=1 ) {
			return CommonReturnType.create(null, "系统中查无数据",null);
		}
		Account accountsys=accountList.get(0);
		// 生成6位随机码 并保存入DB
		String randNumber=(int)((Math.random()*9+1)*100000)+"";
		Account account=new Account();
		account.setId(accountsys.getId());
		account.setStatus(1);
		System.out.println("randNumber_b:"+randNumber);
		account.setPassword(cryptoService.getEncryptText(randNumber));
		System.out.println("randNumber_a:"+cryptoService.getDecryptText(account.getPassword()));
		account.setUpdateDate(new Date());
		
		accountDao.updateByPrimaryKeySelective(account);
		// 发邮件告知6位随机码
		try {
			new Thread(()-> {
				String subject=String.format("账号【%s】已重置,供应商管理系统新密码为【%s】,请尽快登陆！",accountsys.getAccount(),randNumber); 
	            String content="<p style='text-indent:2em'>a)旺旺供应商平台登陆链接：<a href='%s'> %s</a></p>\r\n" + 
	                "<p style='text-indent:2em'>b)此为提醒邮件，请不要直接回复此邮件，谢谢配合</p>";				content=String.format(content,loginUrl,loginUrl);
				//String to="00320558"+"@want-want.com";
				String to=accountsys.getEmail();
				mailServcie.sendHtmlMail(to,subject,content);
			}).start();
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		return CommonReturnType.create(null, "修改重置成功");
	}


	public static void main(String[] args) {
		System.out.println((int)((Math.random()*9+1)*100000));
	    LocalDate date = LocalDate.now();
	    System.out.println("当前日期=" + date);
	}
	
	@Override
	public Map<String, Object> ecologyLogin(HttpServletRequest request) {
		String vt ="";
		String account ="";//员工id
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code","401");
		result.put("userName","");
		result.put("userId", "");
		result.put("message","请开通供应商系统权限");
		
		try {
			vt = CookieUtil.getCookieValue(request, Login.VT.getVal(), "utf-8");
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			logger.error("accoutServiceImpl.ecologyLogin."+e.getMessage());
		}
		
		if(!"".equals(vt) && vt != null){
			String byteSsoUser = "";
			try {
				byteSsoUser = new String(redisService.get(vt));//获取redis中的vt值
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("accoutServiceImpl.ecologyLogin.---vt值无法获取信息"+e.getMessage());
			}
			if (null != byteSsoUser) {
				SsoUser ssoUser = new SsoUser();
				try{
					ssoUser = new Gson().fromJson(byteSsoUser, SsoUser.class);
				}catch (JsonSyntaxException e){
					e.printStackTrace();
					logger.error("accoutServiceImpl.ecologyLogin.---vt值转换失败"+e.getMessage());
				}
				account = ssoUser.getAccount();
				logger.error("oa登录用户:accoutServiceImpl.ecologyLogin."+account);
				logger.error("oa登录用户:accoutServiceImpl.ecologyLogin."+ssoUser.getPassword());
				RoleUserKey roleUserKey = new RoleUserKey();
				roleUserKey.setUserId(account);
				
				//List<RoleUser> roleUserList = roleUserDao.selectRoleByUserId(roleUserKey);
				Account accountParam = accountDao.selectAccountAndRoleById(account);
				if(null == accountParam) {
					return result;
				}
				//User user = getUserInfo(account);
				result.put("userName",accountParam.getName());
				result.put("userId", account);
				logger.info("accoutServiceImpl.ecologyLogin.---用户名"+accountParam.getName());
				List<String> roleList = accountDao.getRolesByAccountId(account);
				String roleS = retunRoles(roleList);
				result.put("roleId",roleS);//角色信息
				result.put("roleIds",roleList);
				result.put("code","200");
				result.put("message", "登录成功！");
			}
		}else {
			logger.info("accoutServiceImpl.ecologyLogin.---vt值是空"+vt);
		}
		return result;
	}

}
