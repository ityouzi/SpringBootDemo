package com.example.springbootdemo.amqp.consumer;

import com.example.springbootdemo.amqp.event.MemberLoginEvent;
import com.example.springbootdemo.amqp.msg.MemberLoginMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 会员登录事件消费者（业务处理）
 *
 * @author lizhen created on 2021-11-08 15:00
 * @version 1.0
 */
@Slf4j
@Service
public class MemberLoginConsumer implements MemberLoginEvent {


    /**
     * 会员登录
     *
     * @param memberLoginMsg
     * @author lizhen
     * @date 2021/11/8-14:59
     * @version 1.0
     */
    @Override
    public void memberLogin(MemberLoginMsg memberLoginMsg) {
        // 具体业务处理
        log.info("完成业务处理");
    }
}
