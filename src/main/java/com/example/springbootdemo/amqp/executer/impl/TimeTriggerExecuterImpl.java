package com.example.springbootdemo.amqp.executer.impl;

import com.example.springbootdemo.amqp.executer.TimeTriggerExecuter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 延迟任务执行器业务实现
 *
 * @author lizhen created on 2021-11-08 15:34
 * @version 1.0
 */
@Slf4j
@Component
public class TimeTriggerExecuterImpl implements TimeTriggerExecuter {



    /**
     * 执行任务
     *
     * @param object 任务参数
     */
    @Override
    public void execute(Object object) {

        log.info("需要延时任务的具体业务逻辑处理");

    }
}
