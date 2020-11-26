package com.want.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.want.entity.User;


@Controller("")
public class RestTest {

	//http://localhost:8081/getparameter
    @RequestMapping(value = "/getparameter", method = RequestMethod.GET)
    @ResponseBody
    public User getparameter(User user) {
        return user;
    }

    //http://localhost:8081/getuser1
    @RequestMapping(value = "/getuser1", method = RequestMethod.GET)
    @ResponseBody
    public User user1() {
        return new User(1, "zhonghua");
    }

    //http://localhost:8081/postuser?id=2&name=jimmy
    @RequestMapping(value = "/postuser", method = RequestMethod.POST)
    @ResponseBody
    public User postUser(@RequestBody User user) {
        System.out.println("name:" + user.getName());
        System.out.println("id:" + user.getId());
        return user;
    }


    
    //http://localhost:8081/success?id=2&name=jimmy
    @ResponseBody
    @RequestMapping(path = "/success")
    public String loginSuccess(String name, Integer id) {
        return "welcome " + name;
    }

    //http://localhost:8081/post?id=2&name=jimmy
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(HttpServletRequest request, @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "password", required = false) String password, @RequestParam(value = "id", required = false) Integer id, HttpServletResponse response) {
       // 如果获取的值为“null”，则需要把URI添加到response信息的header中。添加方法为：“response.addHeader("Location",uri)”
        response.addHeader("Location", "success?name=" + name + "&id=" + id + "&status=success");
        return "redirect:/success?name=" + name + "&id=" + id + "&status=success";
        // return "redirect:/success?name=" + URLEncoder.encode(name, "UTF-8") + "&id=" + id + "&status=success";

    }

    /*************/
    @PutMapping("/testput/{id}")
    @ResponseBody
    public User testput(@PathVariable("id") long id,@RequestBody User user) {
    	System.out.println("id:"+id+",user:"+user);
    	return user;

    }
    
    @DeleteMapping("/testdelete/{id}")
    @ResponseBody
    public long delete(@PathVariable("id") long id) {
    	System.out.println("id:"+id);
    	return id;
    }
}
