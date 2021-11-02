package com.example.springbootdemo.em;

/**
 * 图片文件的类型以及说明
 *
 * @author lizhen created on 2021-10-21 16:22
 * @version 1.0
 */
public enum PictureFileTypeEnum {

    /** 公民身份证正面 */
    FRONT_OF_ID_CARD("00", "公民身份证正面"),
    BUSINESS_LICENSE("19", "营业执照"),
    TAX_REGISTRATION_CERTIFICATE("20", "税务登记证"),
    REVERSE_SIDE_OF_ID_CARD("30", "公民身份证反面"),
    CUSTOMER_AGREEMENT("31", "客户协议"),
    CERTIFICATE_OF_AUTHORIZATION("32", "授权书"),
    FACE_SCAN_WITH_ID_CARD("33", "手持身份证正扫面照"),
    Door_head_photo("34", "门头照"),
    FRONT_OF_BANK_CARD("35", "结算银行卡正面照"),
    REVERSE_SIDE_OF_BANK_CARD("36", "结算银行卡反面照"),
    ACCOUNT_OPENING_PERMIT("37", "开户许可证或印鉴卡"),
    BUSINESS_PREMISES_FIGURE_1("50", "经营场所图 1"),
    BUSINESS_PREMISES_FIGURE_2("51", "经营场所图 2"),


    ;


    private final String value;
    private final String desc;

    PictureFileTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
}
