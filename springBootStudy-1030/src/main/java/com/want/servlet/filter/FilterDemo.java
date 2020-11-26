package com.want.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)//多个filter的时候,该序号越小,越早执行
@WebFilter(filterName = "FilterDemo", urlPatterns = "/tttt")//url过滤配置,非包配置
@Component
public class FilterDemo implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println("----FilterDemo------11111--------");
        //init逻辑,该init将在服务器启动时调用
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //request处理逻辑
        //request在封装逻辑
        //chain重新写回request和response
    	System.out.println("----FilterDemo------222222--------");
    	chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //写destroy逻辑,该destroy逻辑将在服务器关闭时调用
    	System.out.println("----FilterDemo------33333--------");
    }
}