package com.hiron.open.sdk.service.manage.vo;


import lombok.Data;

/**
 * 设备列表 请求参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrDeviceListReqVO {
    
    /**
     * ⻚数(默认1)
     */
    private Integer page;
    
    /**
     * 每页⻚数(默认10 最⼤为50)
     */
    private Integer limit;
    
    /**
     * ⾃贩机名称/扫码贴编码
     */
    private String name;
    
    /**
     * ⾃贩机位置ID
     */
    private Long placeId;
}
