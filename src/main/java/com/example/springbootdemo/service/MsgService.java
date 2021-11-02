package com.example.springbootdemo.service;

import com.example.springbootdemo.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 消息
 *
 * @author lizhen created on 2021-10-18 17:12
 * @version 1.0
 */
@Slf4j
@Service
public class MsgService {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void send(){
        // 消息发送到一个不存在的交换机中
        // rabbitTemplate.convertAndSend("RabbitConfig.JAVABOY_EXCHANGE_NAME",RabbitConfig.JAVABOY_QUEUE_NAME,"hello rabbitmq!".getBytes(),new CorrelationData(UUID.randomUUID().toString()));

        // 真实存在的交换器，但是给一个不存在的队列
        // rabbitTemplate.convertAndSend(RabbitConfig.JAVABOY_EXCHANGE_NAME,"RabbitConfig.JAVABOY_QUEUE_NAME","hello rabbitmq!".getBytes(),new CorrelationData(UUID.randomUUID().toString()));

        // 正确的
        rabbitTemplate.convertAndSend(RabbitConfig.JAVABOY_EXCHANGE_NAME,RabbitConfig.JAVABOY_QUEUE_NAME,"hello rabbitmq!".getBytes(),new CorrelationData(UUID.randomUUID().toString()));

    }
}
