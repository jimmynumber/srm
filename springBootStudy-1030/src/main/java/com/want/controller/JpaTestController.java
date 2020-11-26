package com.want.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.Card;
import com.want.service.impl.CardServiceImpl;
import com.want.vo.CommonResult;

@RestController
@RequestMapping("/jpatest")
public class JpaTestController {

    @Autowired
    private CardServiceImpl service;
 
    //添加一个学生
    @PostMapping(value = "/addCard")
    public CommonResult addCard(@RequestBody Card Card) {
        CommonResult result = new CommonResult();
        try {
            service.addCard(Card);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //修改一个学生(jpa是根据id来修改的)
    @PutMapping(value = "/updateCard")
    public CommonResult updateCardById(@RequestBody  Card Card) {
        CommonResult result = new CommonResult();
        try {
            service.updateCard(Card);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //根据id删除一条数据
    @DeleteMapping(value = "/deleteCard/{id}")
    public CommonResult deleteCardById(@PathVariable(name = "id", required = true) Long id) {
        CommonResult result = new CommonResult();
        try {
            service.deleteCardById(id);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //查询所有
    @GetMapping(value = "/findAll")
    public CommonResult findAll() {
        CommonResult result = new CommonResult();
        try {
            List<Card> list = service.findAll();
            //将查询结果封装到CommonResult中
            result.setData(list);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    //根据id查询一条数据(2.0后不能使用findOne了)
    @GetMapping(value = "/findCardById/{id}")
    public CommonResult findCardById(@PathVariable(name = "id") Long id) {
        CommonResult result = new CommonResult();
        try {
            Card Card = service.findCardById(id);
            //将查询结果封装到CommonResult中
            result.setData(Card);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }
 
    // http://localhost:8081/jpatest/findAll
    //根据学生姓名查询多条数据
    @GetMapping(value = "/findByNum")
    public CommonResult findByNum(Integer num) {
        CommonResult result = new CommonResult();
        try {
            List<Card> CardList = service.findByNum(num);
            //将查询结果封装到CommonResult中
            result.setData(CardList);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            result.setState(500);
            result.setMsg("失败");
            return result;
        }
    }


}
