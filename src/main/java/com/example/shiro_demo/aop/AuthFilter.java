package com.example.shiro_demo.aop;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.shiro_demo.utils.ResultUtils;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XingGao
 * @Date: 2022/03/24 14:34
 * @Description:
 */
public class AuthFilter extends AuthenticatingFilter {

    Gson gson=new Gson();

    // 生成自定义token
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        //从header中获取token
        String token=httpServletRequest.getHeader("token");
        return new AuthToken(token);
    }

    // 所有请求全部拒绝访问
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //允许option请求通过
        if (((HttpServletRequest) request).getMethod().equals(RequestMethod.OPTIONS.name())) {
            return true;
        }
        return false;
    }

    // 拒绝访问的请求，onAccessDenied方法先获取 token，再调用executeLogin方法
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpServletResponse= (HttpServletResponse) response;
        httpServletResponse.setContentType("application/json;charset=utf-8");
        String token=httpServletRequest.getHeader("token");
        if(StringUtils.isBlank(token)){
            httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpServletResponse.setHeader("Access-Control-Allow-Origin",httpServletRequest.getHeader("Origin") );
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.getWriter().write(gson.toJson(ResultUtils.error("请先登录")));
            return false;
        }
        return executeLogin(request,response);
    }

    // token失效时调用
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest= (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json;charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpResponse.setCharacterEncoding("UTF-8");
        try {
            // 处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            httpResponse.getWriter().write(gson.toJson("登录凭证已失效，请重新登录"));
        } catch (IOException e1) {
        }
        return true;
    }
}
