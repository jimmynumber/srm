package com.want.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
//作用范围
@WebFilter(urlPatterns = "/*")
public class FilterDemo01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    	System.out.println("----FilterDemo01------11111--------");
    }
 
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            System.out.println("拦截器");
            System.out.println("----FilterDemo01------222222--------");
            filterChain.doFilter(servletRequest,servletResponse);
            
    }
 
    @Override
    public void destroy() {
    	System.out.println("----FilterDemo01------33333333--------");
    }
}
