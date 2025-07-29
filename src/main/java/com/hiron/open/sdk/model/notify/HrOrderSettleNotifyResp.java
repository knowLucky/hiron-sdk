package com.hiron.open.sdk.model.notify;


import lombok.Data;

import java.util.List;

/**
 * 订单结算通知
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Data
public class HrOrderSettleNotifyResp {
    /**
     * 开门请求id
     */
    private String tradeRequestId;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 用户标识
     */
    private String userCode;

    /**
     * 扫码贴code
     */
    private String scanCode;

    /**
     * 开门时间戳
     */
    private Long openDoorTime;

    /**
     * 开门总重量（单位：克）
     */
    private Double openDoorWeight;

    /**
     * 关门时间戳
     */
    private Long closeDoorTime;

    /**
     * 关门总重量（单位：克）
     */
    private Double closeDoorWeight;

    /**
     * 购物视频地址集合
     */
    private List<String> videoUrls;

    /**
     * 商品列表
     */
    private List<OrderGoods> orderGoodsList;

    /**
     * 商品信息内部类
     */
    @Data
    public static class OrderGoods {
        /**
         * 商品编码
         */
        private String goodsCode;
        
        /**
         * 商品名称
         */
        private String goodsName;
        
        /**
         * 商品单价（单位：分）
         */
        private Integer goodsPrice;
        
        /**
         * 商品数量
         */
        private Integer goodsCount;
        
        /**
         * 商品图片地址
         */
        private String goodsImgUrl;
    }
}
