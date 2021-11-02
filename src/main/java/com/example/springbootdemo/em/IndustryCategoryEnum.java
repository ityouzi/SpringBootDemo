package com.example.springbootdemo.em;

/**
 * 行业类别
 *
 * @author lizhen created on 2021-10-21 16:54
 * @version 1.0
 */
public enum IndustryCategoryEnum {
    /** 服饰鞋包 */
    INDUSTRY_CATEGORY_01("01", "服饰鞋包"),
    INDUSTRY_CATEGORY_02("02", "数码家电"),
    INDUSTRY_CATEGORY_03("03", "鲜花礼品"),
    INDUSTRY_CATEGORY_04("04", "美容护肤"),
    INDUSTRY_CATEGORY_05("05", "团购"),
    INDUSTRY_CATEGORY_06("06", "机票旅游"),
    INDUSTRY_CATEGORY_07("07", "商务办公"),
    INDUSTRY_CATEGORY_08("08", "文体用品"),
    INDUSTRY_CATEGORY_09("09", "图书音像"),
    INDUSTRY_CATEGORY_10("10", "家居装潢"),
    INDUSTRY_CATEGORY_11("11", "母婴儿童"),
    INDUSTRY_CATEGORY_12("12", "健康保健"),
    INDUSTRY_CATEGORY_13("13", "食品饮料"),
    INDUSTRY_CATEGORY_14("14", "资讯杂志"),
    INDUSTRY_CATEGORY_15("15", "教育咨询"),
    INDUSTRY_CATEGORY_16("16", "金融保险理财"),
    INDUSTRY_CATEGORY_17("17", "软件定制创意"),
    INDUSTRY_CATEGORY_18("18", "虚拟点卡"),
    INDUSTRY_CATEGORY_19("19", "域名主机"),
    INDUSTRY_CATEGORY_20("20", "电子商务"),
    INDUSTRY_CATEGORY_21("21", "酒店预订"),
    INDUSTRY_CATEGORY_22("22", "彩票"),
    INDUSTRY_CATEGORY_23("23", "打车、智慧城市"),
    INDUSTRY_CATEGORY_24("24", "移动支付手游"),
    INDUSTRY_CATEGORY_25("25", "融资租赁"),
    INDUSTRY_CATEGORY_26("26", "投资理财"),
    INDUSTRY_CATEGORY_27("27", "保险行业"),

    INDUSTRY_CATEGORY_31("31", "消费分期"),
    INDUSTRY_CATEGORY_32("32", "其他行业"),
    INDUSTRY_CATEGORY_33("33", "小贷消金"),
    INDUSTRY_CATEGORY_34("34", "直播行业"),
    INDUSTRY_CATEGORY_35("35", "信息咨询"),
    INDUSTRY_CATEGORY_36("36", "综合商城"),

    INDUSTRY_CATEGORY_41("41", "机械设备"),
    INDUSTRY_CATEGORY_42("42", "直销行业"),
    INDUSTRY_CATEGORY_43("43", "通信行业"),
    INDUSTRY_CATEGORY_44("44", "汽车贸易"),
    INDUSTRY_CATEGORY_45("45", "拍卖"),
    INDUSTRY_CATEGORY_46("46", "税务服务"),
    INDUSTRY_CATEGORY_47("47", "情趣用品"),
    INDUSTRY_CATEGORY_48("48", "供应链服务"),
    INDUSTRY_CATEGORY_49("49", "医疗服务"),
    INDUSTRY_CATEGORY_50("50", "酒店管理"),
    INDUSTRY_CATEGORY_51("51", "跨境直购"),
    INDUSTRY_CATEGORY_52("52", "银行机构"),
    INDUSTRY_CATEGORY_53("53", "事业单位"),

    INDUSTRY_CATEGORY_55("55", "租赁行业"),
    INDUSTRY_CATEGORY_56("56", "人力资源"),
    INDUSTRY_CATEGORY_57("57", "房地产"),
    INDUSTRY_CATEGORY_58("58", "批发零售业"),
    INDUSTRY_CATEGORY_59("59", "制造业"),
    INDUSTRY_CATEGORY_60("60", "文化活动服务"),
    INDUSTRY_CATEGORY_61("61", "福利彩票"),
    INDUSTRY_CATEGORY_62("62", "股票操盘"),
    INDUSTRY_CATEGORY_63("63", "众筹"),

    INDUSTRY_CATEGORY_66("66", "大宗商品"),
    INDUSTRY_CATEGORY_67("67", "服装鞋包"),
    INDUSTRY_CATEGORY_68("68", "互联网金融"),
    INDUSTRY_CATEGORY_69("69", "话费充值"),
    INDUSTRY_CATEGORY_70("70", "计算机软件"),
    INDUSTRY_CATEGORY_71("71", "计算机系统集成"),
    INDUSTRY_CATEGORY_72("72", "建筑工程"),
    INDUSTRY_CATEGORY_73("73", "理财投资"),
    INDUSTRY_CATEGORY_74("74", "金融租赁"),
    INDUSTRY_CATEGORY_75("75", "旅游机票"),

    INDUSTRY_CATEGORY_78("78", "人力资源"),
    INDUSTRY_CATEGORY_79("79", "生活服务"),
    INDUSTRY_CATEGORY_80("80", "软件定制商城"),

    INDUSTRY_CATEGORY_82("82", "物流运输"),
    INDUSTRY_CATEGORY_83("83", "消费金融"),
    INDUSTRY_CATEGORY_84("84", "物业管理"),
    INDUSTRY_CATEGORY_85("85", "小额贷款"),
    INDUSTRY_CATEGORY_86("86", "游戏行业"),
    INDUSTRY_CATEGORY_87("87", "游戏点卡"),
    INDUSTRY_CATEGORY_88("88", "影视传媒"),
    INDUSTRY_CATEGORY_89("89", "艺术品类"),

    INDUSTRY_CATEGORY_1001("1001", "餐饮娱乐类"),
    INDUSTRY_CATEGORY_1002("1002", "一般类"),
    INDUSTRY_CATEGORY_1003("1003", "民生类"),
    INDUSTRY_CATEGORY_1004("1004", "便民服务"),
    INDUSTRY_CATEGORY_1005("1005", "环保类"),



    ;


    private final String value;
    private final String desc;

    IndustryCategoryEnum(String value, String desc) {
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
