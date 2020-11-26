package com.want.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.want.exception.BusinessException;
import com.want.exception.ResultEnum;

@RestController
@RequestMapping("/BusinessException")
public class ExceptionController {
    @GetMapping("/test")
    public String testResponseStatusExceptionResolver(@RequestParam("i") int i){
        if (i==0){
            // throw new BusinessException(600,"自定义业务错误");
        	 throw new BusinessException(ResultEnum.ERROR);
            //throw new BusinessException(ResultEnum.ERROR.getCode(),ResultEnum.ERROR.getMsg());
        }
              return "success";
    }

}