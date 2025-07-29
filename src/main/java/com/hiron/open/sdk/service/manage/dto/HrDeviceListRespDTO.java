package com.hiron.open.sdk.service.manage.dto;


import lombok.Data;

/**
 * 设备列表响应参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrDeviceListRespDTO {
    
    /**
     * 设备名称
     */
    private String deviceName;
    
    /**
     * 设备扫描码
     */
    private String scanCode;
    
    /**
     * 设备条码
     */
    private String deviceSn;
    
    /**
     * 设备资产编号
     */
    private String assetCode;
    
    /**
     * 设备位置
     */
    private String location;
    
    /**
     * 设备位置id
     */
    private Long placeId;
    
    /**
     * 设备更新时间
     */
    private Long updateTimestamp;
}
