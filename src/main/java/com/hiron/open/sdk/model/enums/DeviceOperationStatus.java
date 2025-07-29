package com.hiron.open.sdk.model.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 设备操作状态码枚举
 * 
 * @author Luckymi
 * @since 2025/6/24
 */
@Getter
@AllArgsConstructor
public enum DeviceOperationStatus {

    // 成功状态
    REQUEST_SUCCESS(200, "发送开门请求成功"),
    OPEN_DOOR_SUCCESS(201, "开门成功"),
    CLOSE_DOOR_SUCCESS(202, "关门成功"),
    START_SETTLEMENT(203, "开始结算"),
    SETTLEMENT_COMPLETED(205, "结算完成"),

    // 开门失败状态 - 业务逻辑相关
    OPEN_FAIL_PREVIOUS_SHOPPING_NOT_ENDED(2031, "开门失败，上一次购物尚未结束（没有关门落锁）"),
    OPEN_FAIL_PREVIOUS_RESTOCK_NOT_ENDED(2032, "开门失败，上一个补货尚未结束（没有关门落锁）"),
    OPEN_FAIL_POWER_OUTAGE_UPS_MODE(2033, "开门失败，设备断电，机柜处于UPS状态"),
    OPEN_FAIL_MAINTENANCE_MODE(2034, "开门失败，设备处于运维模式中"),
    OPEN_FAIL_BACKGROUND_PROCESSING(204, "开门失败，设备后台进程在进行视频压缩等"),

    // 开门失败状态 - 通信相关
    CLIENT_TIMEOUT(503, "客户端接受消息超时"),
    OPEN_FAIL_TIMEOUT(503, "开门失败，设备收到消息超时(20s)"),
    OPEN_FAIL_NO_REPORT(504, "开门失败，设备没有在5分钟内上报开门结果"),

    // 开门失败状态 - 硬件故障相关
    OPEN_FAIL_SERIAL_PORT_ERROR(5051, "开门失败，设备串口故障"),
    OPEN_FAIL_SENSOR_ERROR(5052, "开门失败，设备重感故障"),
    OPEN_FAIL_ALL_CAMERAS_OFFLINE(5053, "开门失败，设备摄像头全部掉线"),
    OPEN_FAIL_LOCAL_ALGORITHM_ERROR(5054, "开门失败，本地识别算法异常"),
    OPEN_FAIL_DOOR_LOCK_ERROR(5055, "开门失败，门锁异常"),
    OPEN_FAIL_POWER_SUPPLY_ERROR(5056, "设备供电状态错误"),

    // 门锁异常状态
    DOOR_LOCK_ABNORMAL_OPEN_UNLOCK(5057, "门锁异常-门开锁开"),
    DOOR_LOCK_ABNORMAL_CLOSE_UNLOCK(5058, "门锁异常-门关锁开"),
    DOOR_LOCK_ABNORMAL_OPEN_LOCK(5059, "门锁异常-门开锁关"),
    DOOR_LOCK_ABNORMAL_CLOSE_LOCK(5060, "门锁异常-门关锁关"),

    // 参数错误
    TYPE_PARAMETER_ERROR(400, "类型参数（type）错误"),
    TYPE_PARAMETER_ERROR_ALT(40005, "类型参数（type）错误"),

    // 设备状态
    RESULT_NOT_REPORTED(404, "设备还没有上报结果"),
    DEVICE_OFFLINE(10416, "设备离线"),
    VENDING_MACHINE_NOT_IN_OPERATION(40525, "自贩机未在运营中"),
    TOO_MANY_UNFINISHED_ORDERS(40526, "自贩机未完成订单过多"),
    VENDING_MACHINE_NOT_EXIST(40506, "自贩机不存在"),
    MERCHANT_MISMATCH(40531, "非本商户自贩机"),
    NOT_BELONG_TO_MERCHANT(40531, "自贩机不属于该商户"),

    // 商品异常
    PRODUCT_PACKAGE_EXCEPTION(3501, "自贩机商品包异常"),

    // 权限相关
    NO_QUERY_PERMISSION(42403, "没有查询权限"),
    REQUEST_ID_NOT_EXIST(42404, "开门请求id不存在"),

    // 订单相关
    ORDER_NOT_FOUND(40564, "找不到订单"),
    REFUND_NOT_FOUND(40917, "找不到退款单");


    private final int code;
    private final String description;

    /**
     * 根据状态码获取枚举实例
     * @param code 状态码
     * @return 对应的枚举实例，如果找不到返回null
     */
    public static DeviceOperationStatus getByCode(int code) {
        for (DeviceOperationStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        return null;
    }

    /**
     * 判断是否是成功状态
     * @return 如果是成功状态返回true，否则返回false
     */
    public boolean isSuccess() {
        return code == OPEN_DOOR_SUCCESS.code || code == CLOSE_DOOR_SUCCESS.code ||
                code == START_SETTLEMENT.code || code == SETTLEMENT_COMPLETED.code ||
                code == REQUEST_SUCCESS.code;
    }

    /**
     * 判断是否是开门失败状态
     * @return 如果是开门失败状态返回true，否则返回false
     */
    public boolean isOpenFailure() {
        return (code >= 2031 && code <= 204) ||
                (code >= 503 && code <= 5056) ||
                (code >= 5057 && code <= 5060);
    }

    /**
     * 判断是否是门锁异常状态
     * @return 如果是门锁异常状态返回true，否则返回false
     */
    public boolean isDoorLockAbnormal() {
        return code >= 5057 && code <= 5060;
    }
}
