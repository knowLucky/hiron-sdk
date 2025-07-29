package com.hiron.open.sdk.model.notify;


import lombok.Data;

/**
 * 商品信息基础类
 * 
 * @author Luckymi
 * @since 2025/6/25
 */
@Data
public class HrGoodsInfoBaseParams {
    /**
     * 商品编码
     */
    private String goodsCode;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品价格（单位：元）
     */
    private Double goodsPrice;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 商品图片地址
     */
    private String goodsImgUrl;
}
