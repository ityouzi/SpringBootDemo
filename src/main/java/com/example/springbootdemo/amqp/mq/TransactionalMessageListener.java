package com.example.springbootdemo.amqp.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * 对ApplicationEventPublisher的publishEvent的监听，默认在事务提交后执行
 *
 * @author fk
 * @version v7.2.0
 * @since v7.2.0
 * 2020-06-15 21:50:52
 */
@Component
public class TransactionalMessageListener {

    private static final Logger log = LoggerFactory.getLogger(TransactionalMessageListener.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 默认在事务提交后执行
     * @param message
     */
    @TransactionalEventListener(fallbackExecution = true)
    public void handleSupplierBillPush(MqMessage message){
        log.info("=========== TransactionalMessageListener 事务提交之后执行 amqpTemplate.convertAndSend()方法 ===========");
        this.amqpTemplate.convertAndSend(message.getExchange(), message.getRoutingKey(), message.getMessage());

    }
}
