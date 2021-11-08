package com.example.springbootdemo.amqp.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 路由配置
 *
 * @author lizhen created on 2021-11-08 15:16
 * @version 1.0
 */
@Configuration
public class TimeTriggerConfig {

    /**
     * 队列枚举
     */
    public final static String IMMEDIATE_QUEUE_XDELAY = "IMMEDIATE_QUEUE_XDELAY";
    /**
     * 交换机
     */
    public final static String DELAYED_EXCHANGE_XDELAY = "DELAYED_EXCHANGE_XDELAY";
    /**
     * routing
     */
    public final static String DELAY_ROUTING_KEY_XDELAY = "DELAY_ROUTING_KEY_XDELAY";

    @Bean
    public CustomExchange delayExchange(){
        Map<String, Object> args = new HashMap<>();
        args.put("x-delayed-type", "direct");
        return new CustomExchange(DELAYED_EXCHANGE_XDELAY, "x-delayed-messag", true, false, args);
    }

    /**
     * 生命队列
     */
    @Bean
    public Queue queue(){
        return new Queue(IMMEDIATE_QUEUE_XDELAY, true);
    }

    /**
     * 绑定交换机
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(delayExchange()).with(IMMEDIATE_QUEUE_XDELAY).noargs();
    }

}
