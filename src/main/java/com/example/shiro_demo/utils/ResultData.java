package com.example.shiro_demo.utils;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * The type Result data.
 *
 * @author XingGao
 * @date 2021 /10/20 11:13
 * @params 统一接口返回
 * @return ResultData
 */
@Data
@ResponseBody
public class ResultData {

    /**
     * 构造方法
     *
     * @param success the success
     * @param code    the code
     * @param message the message
     * @param time    the time
     * @param data    the data
     */
    public ResultData(Boolean success, Integer code, String message, Date time, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.timestamp = time;
        this.data = data;
    }

    /**
     * 返回结果编码
     */
    private Boolean success;

    /**
     * 返回结果编码
     */
    private Integer code;
    /**
     * 返回状态信息
     */
    private String message;
    /**
     * 返回结果时间
     */
    @DateTimeFormat
    private Date timestamp;
    /**
     * 返回结果数据
     */
    private Object data;

}