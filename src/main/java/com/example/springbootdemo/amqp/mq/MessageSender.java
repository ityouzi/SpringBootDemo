package com.example.springbootdemo.amqp.mq;

/**
 * mq的publisher
 *
 * @author lizhen created on 2021-11-08 14:51
 * @version 1.0
 */
public interface MessageSender {

    /**
     * 发布
     *
     * @author lizhen
     * @date 2021/11/8-14:51
     * @version 1.0
     */
    void send(MqMessage mqMessage);
}
