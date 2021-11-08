package com.example.springbootdemo.amqp.event;

import com.example.springbootdemo.amqp.msg.MemberLoginMsg;

/**
 * 会员登录事件接口
 *
 * @author lizhen created on 2021-11-08 14:58
 * @version 1.0
 */
public interface MemberLoginEvent {

    /**
     * 会员登录
     *
     * @param memberLoginMsg
     * @author lizhen
     * @date 2021/11/8-14:59
     * @version 1.0
     */
    void memberLogin(MemberLoginMsg memberLoginMsg);
}
