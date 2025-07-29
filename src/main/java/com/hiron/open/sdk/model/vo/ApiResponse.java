package com.hiron.open.sdk.model.vo;


import lombok.Data;

/**
 * 基础返回参数
 * 
 * @author Luckymi
 * @since 2025/6/19
 */
@Data
public class ApiResponse<T> {
    
    /**
     * 响应状态码
     */
    private String status;
    
    /**
     * 响应信息
     */
    private String message;
    
    /**
     * 响应结果
     */
    private T data;
    
    /**
     * 响应结果
     */
    private T result;
    
    /**
     * 响应结果数量
     */
    private String count;
    
    /**
     * 响应结果
     */
    private String ok;
}
