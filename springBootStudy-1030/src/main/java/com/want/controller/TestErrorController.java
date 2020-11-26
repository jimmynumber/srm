package com.want.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
/*springboot提供了默认的错误映射地址error
@RequestMapping("${server.error.path:${error.path:/error}}")
@RequestMapping("/error")
上面2种写法都可以
*/
@RequestMapping("/error")
//继承springboot提供的ErrorController
public class TestErrorController implements ErrorController {
    //一定要重写方法,默认返回null就可以,不然报错,因为getErrorPath为空.
    @Override
    public String getErrorPath() {
        return null;
    }

    //http://localhost:8081/error
    //一定要添加url映射,指向error
    @RequestMapping
    public Map<String, Object> handleError() {
        //用Map容器返回信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code", 404);
        map.put("msg", "不存在");
        return map;
    }
    /*这里加一个能正常访问的页面,作为比较
    因为写在一个控制器所以它的访问路径是
    http://localhost:8081/error/ok*/
    @RequestMapping("/ok")
    @ResponseBody
    public Map<String, Object> noError() {
        //用Map容器返回信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("code ", 200);
        map.put("msg", "正常，这是测试页面");

        return map;
    }


}
