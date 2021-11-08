package com.example.springbootdemo.amqp.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * mq的publisher
 *
 * @author lizhen created on 2021-11-08 14:50
 * @version 1.0
 */
@Service
public class MessageSenderImpl implements MessageSender{

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * 发布
     *
     * @param mqMessage
     * @author lizhen
     * @date 2021/11/8-14:51
     * @version 1.0
     */
    @Override
    public void send(MqMessage mqMessage) {
        publisher.publishEvent(mqMessage);
    }
}
