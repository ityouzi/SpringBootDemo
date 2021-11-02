package com.example.springbootdemo.model;

import lombok.Data;

/**
 * 商户注册查询返回
 *
 * @author lizhen created on 2021-10-22 14:06
 * @version 1.0
 */
@Data
public class QueryResponse {
    private String code;
    private String msg;

    // 注册同步返回参数
    /** 用户名 */
    private String usercode;
    /** 客户名 */
    private String custname;
    /** 客户id */
    private String custid;
    /** 用户状态 */
    private String user_status;
    /** 创建时间 */
    private String createtime;
    /** 客户状态 */
    private String cust_status;
    /** 子商户是否需要电子合同 */
    private String is_need_contract;
    /** 平台商唯一标识 */
    private String merchant_no;
    /** 备注 */
    private String note;

    // 下面的是商户注册查询异步返回才有的参数

    /** 电子合同预览地址 */
    private String online_url;
    /** 电子合同下载地址 */
    private String offline_url;
    /** 通知类型 */
    private String notify_type;
    /** 发送请求的时间，格式"yyyy-MM-dd HHmmss" */
    private String notify_time;
    /** 签名类型 */
    private String sign_type;
    /** 签名字符串，Base64编码 */
    private String sign;
}
