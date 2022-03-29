package com.example.shiro_demo.utils;


import java.util.Date;

/**
 * The type Result utils.
 */
public class ResultUtils {

    private static final Date TIME = new Date();
    /**
     * 结果返回
     *
     * @param object
     * @return
     */
    public static final int OK = 20000;//成功
    /**
     * The constant ERROR.
     * 失败
     */
    public static final int ERROR = 50000;
    /**
     * The constant LOGINERROR.
     * 用户名或密码错误
     */
    public static final int LOGINERROR = 20002;
    /**
     * The constant ACCESSERROR.
     * 权限不足
     */
    public static final int ACCESSERROR = 20003;
    /**
     * The constant ACCESSERROR.
     * 身份验证过期，失败
     */
    public static final int IDENTITYERROR = 20001;
    /**
     * The constant REMOTEERROR.
     * 远程调用失败
     */
    public static final int REMOTEERROR = 20004;
    /**
     * The constant REPERROR.
     * 重复操作
     */
    public static final int REPERROR = 20005;

    /**
     * 定义操作结果
     *
     * @param msg the msg
     * @return the result data
     */
    public static ResultData error(String msg) {
        return new ResultData(false, ERROR, msg, TIME, null);
    }

    /**
     * Error result data.
     *
     * @param msg    the msg
     * @param object the object
     * @return the result data
     */
    public static ResultData error(String msg,Object object) {
        return new ResultData(false, ERROR, msg, TIME, object);
    }

    /**
     * Ok result data.
     *
     * @param object the object
     * @return the result data
     */
    public static ResultData ok(Object object) {
        return new ResultData(true, OK, "操作成功", TIME, object);
    }


    /**
     * Login error result data.
     *
     * @return the result data
     */
    public static ResultData loginError() {
        return new ResultData(false, LOGINERROR, "用户名或密码错误", TIME, null);
    }

    /**
     * Remote error result data.
     *
     * @return the result data
     */
    public static ResultData remoteError() {
        return new ResultData(false, REMOTEERROR, "远程调用失败", TIME, null);
    }

    /**
     * Power error result data.
     *
     * @return the result data
     */
    public static ResultData powerError() {
        return new ResultData(false, ACCESSERROR, "操作权限不足", TIME, null);
    }

    /**
     * Identity error result data.
     *
     * @param message the message
     * @return the result data
     */
    public static ResultData identityError(String message) {
        return new ResultData(false, IDENTITYERROR, message, TIME, null);
    }

    /**
     * Pep error result data.
     *
     * @return the result data
     */
    public static ResultData pepError() {
        return new ResultData(false, REPERROR, "重复操作", TIME, null);
    }

    /**
     * Success result data.
     *
     * @param msg    the msg
     * @param object the object
     * @return the result data
     */
    public static ResultData success(String msg, Object object) {
        return new ResultData(true, OK, msg, TIME, object);
    }

    /**
     * Custom error result data.
     *
     * @param code   the code
     * @param msg    the msg
     * @param object the object
     * @return the result data
     */
    public static ResultData customError(int code, String msg, Object object) {
        return new ResultData(false, code, msg, TIME, object);
    }
}