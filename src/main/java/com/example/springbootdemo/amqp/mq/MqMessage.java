package com.example.springbootdemo.amqp.mq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * mq消息体
 *
 * @author lizhen created on 2021-11-08 14:49
 * @version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MqMessage {

    private String exchange;

    private String routingKey;

    private Object message;

}
