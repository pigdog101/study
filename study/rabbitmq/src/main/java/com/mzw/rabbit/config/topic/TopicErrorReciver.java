package com.mzw.rabbit.config.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @QueueBinding value :配置队列名称
 *               exchange：配置交换器名称
 *
 *
 * @Queue value：配置队列名称
 *        autoDelete：是否是一个可删除的临时队列
 *
 * @Exchange value:配置交换器名称
 *           type:配置交换器的类型
 */
@Component
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "${mq.queue.topic.error}",autoDelete = "true"),
                exchange = @Exchange(value = "${mq.config.topic.exchange}",type = ExchangeTypes.TOPIC),
                key = "*.log.error"
        )
)
public class TopicErrorReciver {
    /**
     * 接收消息
     */
    @RabbitHandler
    public void process(String message){
        System.out.println("rabbit_topic_error_message-->" + message);
    }
}
