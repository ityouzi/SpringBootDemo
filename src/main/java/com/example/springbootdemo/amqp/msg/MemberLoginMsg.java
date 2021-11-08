package com.example.springbootdemo.amqp.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * 会员登录消息
 *
 * @author lizhen created on 2021-11-08 14:45
 * @version 1.0
 */
@Data
public class MemberLoginMsg implements Serializable {

    private static final long serialVersionUID = 4590139519275809967L;


    /**
     * 会员id
     */
    private Long memberId;
    /**
     * 上次登录时间
     */
    private Long lastLoginTime;

    /**
     * 会员还是商家登录 1 会员  2 商家
     */
    private Integer memberOrSeller;
}
