package com.hiron.open.sdk.service.manage.dto;


import lombok.Data;

/**
 * 商品列表返回参数
 * 
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrDeviceGoodsListRespDTO {
    
    /**
     * 商品编码
     */
    private String goodsCode;
    
    /**
     * 商品名称
     */
    private String goodsName;
    
    /**
     * 商品图片
     */
    private String goodsImg;
    
    /**
     * 商品价格 (单位：分)  
     */
    private Integer actualPrice;
    
}
