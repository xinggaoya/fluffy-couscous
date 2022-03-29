package com.example.shiro_demo.aop;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XingGao
 * @Date: 2022/03/24 15:16
 * @Description:
 */
public class AuthToken extends UsernamePasswordToken {
    String token;

    public AuthToken(String token){
        this.token=token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
