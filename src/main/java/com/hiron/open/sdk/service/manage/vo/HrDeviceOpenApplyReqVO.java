package com.hiron.open.sdk.service.manage.vo;


import lombok.Data;

/**
 * 设备开门 请求参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrDeviceOpenApplyReqVO {
    
    /**
     * 开⻔请求ID，需要保证唯⼀ (订单号）
     */
    private String requestId;
    
    /**
     * 扫描码
     */
    private String scanCode;
    
    /**
     * 用户标识 (标识开⻔的⽤户, ⽤来做屏幕信息展示）
     */
    private Long userCode;
    
    /**
     * 本地时间戳
     */
    private Long localTimestamp;
}
