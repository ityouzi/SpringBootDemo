package com.example.springbootdemo.model;

import lombok.Data;

/**
 * 商户注册查询返回
 *
 * @author lizhen created on 2021-10-22 14:06
 * @version 1.0
 */
@Data
public class RegisterQueryResponseBean {
    private String sign;
    private QueryResponse ysepay_merchant_register_query_response;
}
