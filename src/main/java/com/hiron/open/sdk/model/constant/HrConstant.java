package com.hiron.open.sdk.model.constant;


import lombok.Data;

/**
 * @author Luckymi
 * @since 2025/6/20
 */
@Data
public class HrConstant {
    
    /*        签名使用常量             */
    
    public static final String HR = "HR"; 
    public static final String CLIENT = "Client";
    public static final String COOP = "coop";
    public static final String MERCHANT_CODE = "MerchantCode";
    public static final String FALSE = "false";
    public static final String SUCCESS = "success";
    
    
    /*        Redis使用常量             
    *   200		发送开门请求成功		
    *   201		开门成功		
    *   202		关门成功		
    *   203  	开始结算
    *   205		结算完成
    *   206		开门失败
    * 
    * */
    
    public static final String DOOR_REDIS = "gruul:hiron:vending:door:state:";
    public static final String CURRENT_USER = "gruul:hiron:vending:current:user:";
    public static final int REQUEST_SUCCESS = 200;
    public static final int OPEN_DOOR_SUCCESS = 201;
    public static final int CLOSE_DOOR_SUCCESS = 202;
    public static final int START_SETTLEMENT = 203;
    public static final int SETTLEMENT_COMPLETED = 205;
    public static final int CANCEL_ORDER = 206;
    
    
    /*        回调使用常量             */
    
    public static final String BAST_WX_SCORE_NOTIFY_URL = "/hiron/pay/score/notify"; 
    
}
