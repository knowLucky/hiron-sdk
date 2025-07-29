package com.hiron.open.sdk.service.manage.dto;


import lombok.Data;

import java.util.List;

/**
 * 查询设备开门 返回参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrOpenDoorResultRespDTO {
    
    /**
     * 订单编号
     */
    private String tradeRequestId;
    
    /**
     * 订单ID
     */
    private Long orderId;
    
    /**
     * 扫码结果
     */
    private String scanCode;
    
    /**
     * 用户编号
     */
    private String userCode;
    
    /**
     * 处理状态
     */
    private Integer handleStatus;
    
    /**
     * 总金额
     */
    private Integer totalFee;
    
    /**
     * 开门时间
     */
    private String openDoorTime;
    
    /**
     * 关门时间
     */
    private String closeDoorTime;
    
    /**
     * 开门重量
     */
    private Integer openDoorWeight;
    
    /**
     * 关门重量
     */
    private Integer closeDoorWeight;
    
    /**
     * 商品列表
     */
    private List<HrDeviceGoodsListRespDTO> goodsList;
}
