package com.example.springbootdemo.em;

/**
 * 证件类别
 *
 * @author lizhen created on 2021-10-21 16:18
 * @version 1.0
 */
public enum IdTypeEnum {
    /** 公民身份证正面 */
    FRONT_OF_ID_CARD("00", "公民身份证正面"),
    CHINESE_PASSPORT("01", "中国护照"),
    MILITARY_ID_CARD("02", "军人身份证"),
    POLICE_OFFICER_CARD("03", "警官证"),
    RESIDENCE_BOOKLET("04", "户口簿"),
    TEMPORARY_ID_CARD("05", "临时身份证"),
    FOREIGN_PASSPORT("06", "外国护照"),
    HONG_KONG_AND_MACAO_PASS("07", "港澳通行证"),
    TAIWAN_COMPATRIOTS_PASS("08", "台胞通行证"),
    RETIREMENT_CERTIFICATE("09", "离休干部荣誉证"),
    OFFICER_RETIREMENT_CERTIFICATE("10", "军官退休证"),
    CADRE_RETIREMENT_CERTIFICATE("11", "文职干部退休证"),
    STUDENT_CARD("12", "军事院校学员证"),
    POLICE_ID_CARD("13", "武装警察身份证"),
    CERTIFICATE_OF_OFFICERS("14", "军官证"),
    CIVILIAN_CADRE_CERTIFICATE("15", "文职干部证"),
    SOLDIER_CERTIFICATE("16", "军人士兵证"),
    ARMED_POLICE_SOLDIER_CERTIFICATE("17", "武警士兵证"),
    OTHER_DOCUMENTS("18", "其他证件"),
    BUSINESS_LICENSE("19", "营业执照"),
    TAX_REGISTRATION_CERTIFICATE("20", "税务登记证"),
    REVERSE_SIDE_OF_ID_CARD("30", "公民身份证反面"),
    CUSTOMER_AGREEMENT("31", "客户协议"),
    CERTIFICATE_OF_AUTHORIZATION("32", "授权书"),



    ;


    private final String value;
    private final String desc;

    IdTypeEnum(String value, String desc) {
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
