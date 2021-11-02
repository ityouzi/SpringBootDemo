package com.example.springbootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Rabbit配置
 *
 * @author lizhen created on 2021-10-18 16:49
 */
@Slf4j
@Configuration
public class RabbitConfig implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    public static final String JAVABOY_EXCHANGE_NAME = "javaboy_exchange_name";

    public static final String JAVABOY_QUEUE_NAME = "javaboy_queue_name";

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 声明一个队列
     */
    @Bean
    public Queue queue(){
        return new Queue(JAVABOY_QUEUE_NAME, true);
    }

    /**
     * 声明一个死信交换机
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange(JAVABOY_EXCHANGE_NAME);
    }

    /**
     * 绑定一个路由
     */
    @Bean
    public Binding binding(){
        return BindingBuilder.bind(queue()).to(directExchange()).with(JAVABOY_QUEUE_NAME);
    }

    @PostConstruct
    public void initRabbitTemplate(){
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 消息到达交换器的确认回调
     * 
     * @author lizhen 
     * @date 2021/10/18-17:04
     * @version 
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack){
            log.info("{}:消息成功到达交换器", correlationData.getId());
        } else {
            log.error("{}:消息发送失败", correlationData.getId());
        }
    }

    /**
     * 消息路由到队列失败时被调用
     * 
     * @author lizhen 
     * @date 2021/10/18-17:06
     * @version 
     */
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.error("{}:消息未成功路由到队列", returned.getMessage().getMessageProperties().getMessageId());
    }

}
