package com.want.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.want.entity.User;

@RestController
public class RestTemplateTest {

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	// http://localhost:8081/nparameters
	@RequestMapping("/nparameters")
	// 返回String,不带参数
	public String nparameters() {
		RestTemplate client = restTemplateBuilder.build();
		ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8081/getuser1", String.class);
		return responseEntity.getBody();
	}

	//http://localhost:8081/withparameters1
    @RequestMapping("/withparameters1")
    //返回String,带参数
    public String withparameters1() {
        RestTemplate client= restTemplateBuilder.build();
        ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8081/getparameter?name={1}&id={2}", String.class, "hua",2);
        return responseEntity.getBody();
    }
    
    //http://localhost:8081/withparameters2
    @RequestMapping("/withparameters2")
    //返回String,带参数
    public String withparameters2() {
        RestTemplate client= restTemplateBuilder.build();
        Map<String, String> map = new HashMap<>();
        map.put("name", "zhonghuaLong");

        ResponseEntity<String> responseEntity = client.getForEntity("http://localhost:8081/getparameter?name={name}&id=3", String.class, map);
        return responseEntity.getBody();
    }

    //http://localhost:8081/user1
    @RequestMapping("/user1")
    //返回一个自定义类型的对象
    public User restUser1() {
        RestTemplate client= restTemplateBuilder.build();
        ResponseEntity<User> responseEntity = client.getForEntity("http://localhost:8081/getuser1", User.class);
        return responseEntity.getBody();
    }

    //http://localhost:8081/getforobject
	@RequestMapping("/getforobject")
    public User  getForObject() {
        RestTemplate client= restTemplateBuilder.build();
        User user = client.getForObject("http://localhost:8081/getuser1", User.class);
        return user;
	}
	/**********************************************************/
	private RestTemplate restTemplate = new RestTemplate();
	
	// http://localhost:8081/postForEntity
    @GetMapping("/postForEntity")
    public User postForEntity() {
        //RestTemplate client= restTemplateBuilder.build();
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "20180416");
        paramMap.add("id", 4);
        User user = new User();
        user.setName("hongwei");
        user.setId(4);
        //方法的第一参数表示要调用的服务的地址
        //方法的第二个参数表示上传的参数
        //方法的第三个参数表示返回的消息体的数据类型
        ResponseEntity<User> responseEntity = restTemplate.postForEntity("http://localhost:8081/postuser", user, User.class);
        return responseEntity.getBody();
    }
    
    //http://localhost:8081/postForObject
    @RequestMapping("/postForObject")
    public String postForObject() {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "20180416");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        User user = new User();
        user.setName("hongwei");
        user.setId(5);
        String response = client.postForObject("http://localhost:8081/postuser", user, String.class);
        return response;
    }

    //http://localhost:8081/postForLocation
    @RequestMapping("/postForLocation")
    public URI postForLocation() {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "20180416");
        paramMap.add("id", 4);
        RestTemplate client = restTemplateBuilder.build();
        User user = new User();
        user.setName("hongwei");
        user.setId(6);
        URI response = client.postForLocation("http://localhost:8081/postuser", user);
        return response;
    }
    
    //http://localhost:8081/postForexchange
    @RequestMapping("/postForexchange")
    public String postForexchange() {
        // 封装参数，千万不要替换为Map与HashMap，否则参数无法传递
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("name", "20180416");
        paramMap.add("id", 4);
        /*********/
        User user = new User();
        user.setName("hongwei");
        user.setId(6);
        RestTemplate client = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        //headers.set("id", "long");
        HttpEntity<User> httpEntity = new HttpEntity<User>(user,headers);
        ResponseEntity<String> response = client.exchange("http://localhost:8081/postuser",HttpMethod.POST,httpEntity,String.class,user);
        
//        HttpEntity<MultiValueMap<String, Object>> httpEntity1 = new HttpEntity<MultiValueMap<String, Object>>(paramMap,headers);
//        ResponseEntity<String> response1 = client.exchange("http://localhost:8081/postmap",HttpMethod.POST,httpEntity1,String.class,paramMap);
//        System.out.println("response1:"+response1);
        return response.getBody();
    }
    
    /**********************************/
    @RequestMapping("/testput")
    public void put() {
        RestTemplate client= restTemplateBuilder.build();
        User user = new User();
        user.setName("hongwei");
        client.put("http://localhost:8081/testput/{1}", user, 7);
    }
    
    @RequestMapping("/testdelete")
    public void delete() {
        RestTemplate client= restTemplateBuilder.build();
        client.delete("http://localhost:8081/testdelete/{1}", 8);
    }
	
}
