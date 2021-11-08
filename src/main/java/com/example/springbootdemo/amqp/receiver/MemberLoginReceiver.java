package com.example.springbootdemo.amqp.receiver;

import cn.hutool.core.collection.CollectionUtil;
import com.example.springbootdemo.amqp.AmqpExchange;
import com.example.springbootdemo.amqp.event.MemberLoginEvent;
import com.example.springbootdemo.amqp.msg.MemberLoginMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员登录信息接收者
 *
 * @author lizhen created on 2021-11-08 14:53
 * @version 1.0
 */
@Slf4j
@Component
public class MemberLoginReceiver {

    /** 会员登录事件业务接口 */
    @Resource
    private List<MemberLoginEvent> events;


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = AmqpExchange.MEMEBER_LOGIN + "_QUEUE"),
            exchange = @Exchange(value = AmqpExchange.MEMEBER_LOGIN, type = ExchangeTypes.FANOUT)
    ))
    public void memberLogin(MemberLoginMsg memberLoginMsg){
        // 判断是否注入
        if (CollectionUtil.isNotEmpty(events)){
            // 可能有多个
            for (MemberLoginEvent event : events) {
                try {
                    event.memberLogin(memberLoginMsg);
                } catch (Exception e){
                    log.error("会员登录异常", e);
                }
            }
        }

    }

}
