package com.example.springbootdemo.amqp.executer;

/**
 * 延时任务执行器接口
 */
public interface TimeTriggerExecuter {


    /**
     * 执行任务
     * @param object 任务参数
     */
    void execute(Object object);

}
