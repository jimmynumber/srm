package com.want.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.want.entity.User;
import com.want.mapper.UserMapper;

//@RestController
@Controller
@RequestMapping("/MybatisCurdTest")
public class MybatisCurdTest {

	@Autowired
	private UserMapper userMapper;

	//http://localhost:8081/MybatisCurdTest/querybyid?id=1
	@RequestMapping("/querybyid")
	public User queryById(int id) {
		return userMapper.queryById(id);
	}

	// http://localhost:8081/MybatisCurdTest/
	@RequestMapping("/")
	public List<User> queryAll() {
		return userMapper.queryAll();
	}

	// http://localhost:8081/MybatisCurdTest/add?name=jimmy&age=18
	@RequestMapping("/add")
	public String add(User user) {
		return userMapper.add(user) == 1 ? "success" : "failed";
	}

	// http://localhost:8081/MybatisCurdTest/updatebyid?name=jimmy1&age=180&id=1
	@RequestMapping("/updatebyid")
	public String updateById(User user) {
		return userMapper.updateById(user) == 1 ? "success" : "failed";
	}

	//http://localhost:8081/MybatisCurdTest/delbyid?id=1
	@RequestMapping("/delbyid")
	public String delById(int id) {
		return userMapper.delById(id) == 1 ? "success" : "failed";
	}

	//http://localhost:8081/MybatisCurdTest/listall?start=0&size=5
	@RequestMapping("/listall")
    public String listCategory(Model m, @RequestParam(value="start",defaultValue="0")int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        //1. 在参数里接受当前是第几页 start ，以及每页显示多少条数据 size。 默认值分别是0和5。
        //2. 根据start,size进行分页，并且设置id 倒排序
        PageHelper.startPage(start,size,"id desc");
        //3. 因为PageHelper的作用，这里就会返回当前分页的集合了
        List<User> cs = userMapper.queryAll();
        //4. 根据返回的集合，创建PageInfo对象
        PageInfo<User> page = new PageInfo<>(cs);
        System.out.println("page:"+page);
        //5. 把PageInfo对象扔进model，以供后续显示
        m.addAttribute("page", page);
        //System.out.println(page..is.end.e.isIsLastPage().I.getLastPage().f.isIsFirstPage().getFirstPage().getLastPage().isIsFirstPage());
        //6. 跳转到listCategory.jsp
        return "list";
    }
	
    //http://localhost:8081/MybatisCurdTest/listall2?pageNum=1&pageSize=2
    @RequestMapping("/listall2")
    // 如果方法的参数不指定默认值，且请求地址也没有指定参数值，则项目运行时会报错。此处为网友ygl提供的修正建议。
    public Page<User> getUserList(@RequestParam(value="pageNum",defaultValue="0")int pageNum, @RequestParam(value = "pageSize", defaultValue = "5") int pageSize)
    //public Page<User> getUserList(Integer pageNum, Integer pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        Page<User>  userList= userMapper.getUserList();
        return userList;
    }
}
