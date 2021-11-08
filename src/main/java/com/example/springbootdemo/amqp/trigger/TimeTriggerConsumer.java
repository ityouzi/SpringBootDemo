package com.example.springbootdemo.amqp.trigger;

import com.alibaba.fastjson.JSON;
import com.example.springbootdemo.amqp.config.TimeTriggerConfig;
import com.example.springbootdemo.amqp.config.TimeTriggerMsg;
import com.example.springbootdemo.amqp.context.ApplicationContextHolder;
import com.example.springbootdemo.amqp.executer.TimeTriggerExecuter;
import com.example.springbootdemo.amqp.util.RabbitmqTriggerUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 延迟任务 消息消费者
 *
 * @author lizhen created on 2021-11-08 15:07
 * @version 1.0
 */
@Slf4j
@Component
public class TimeTriggerConsumer {

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 接收消息，监听 CONSUMPTION_QUEUE 队列
     */
    @RabbitListener(queues = TimeTriggerConfig.IMMEDIATE_QUEUE_XDELAY)
    public void consume(TimeTriggerMsg timeTriggerMsg){
        try {
            String key = RabbitmqTriggerUtil.generate(timeTriggerMsg.getTriggerExecuter(), timeTriggerMsg.getTriggerTime(), timeTriggerMsg.getUniqueKey());

            // 如果这个任务被标识不执行
            if (redisTemplate.opsForValue().get(key) == null){
                log.debug("执行器执行被取消：" + timeTriggerMsg.getTriggerExecuter() + "|任务标识：" + timeTriggerMsg.getUniqueKey());
                return;
            }

            log.debug("执行器执行：" + timeTriggerMsg.getTriggerExecuter());
            log.debug("执行器参数：" + JSON.toJSONString(timeTriggerMsg.getParam()));

            //执行任务前 清除标识
            redisTemplate.opsForValue().decrement(key);

            TimeTriggerExecuter timeTriggerExecuter = (TimeTriggerExecuter) ApplicationContextHolder.getBean(timeTriggerMsg.getTriggerExecuter());
            timeTriggerExecuter.execute(timeTriggerMsg.getParam());

        } catch (Exception e){
            log.error("延时任务异常：", e);
        }
    }


}
