package com.example.shiro_demo.aop;

import com.google.gson.JsonObject;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: XingGao
 * @Date: 2022/03/24 15:17
 * @Description:
 */
//@ControllerAdvice可以实现全局异常处理，可以简单理解为增强了的controller
@ControllerAdvice
public class MyExceptionHandler {

    //捕获AuthorizationException的异常
    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public JsonObject handleException(AuthorizationException e) {
        JsonObject jsonObject=new JsonObject();
        return jsonObject.getAsJsonObject("权限不足呀！！！！！");
    }
}
