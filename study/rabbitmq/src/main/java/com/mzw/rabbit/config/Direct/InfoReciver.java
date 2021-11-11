package com.mzw.rabbit.config.Direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
                value = @Queue(value = "${mq.queue.direct.info}",autoDelete = "false"),
                exchange = @Exchange(value = "${mq.config.direct.exchange}",type = ExchangeTypes.DIRECT),
                key = "${mq.routing-key.direct.info}"
        )
)
public class InfoReciver {
    private final Logger logger = LoggerFactory.getLogger(InfoReciver.class);
    /**
     * 接收消息
     */
    @RabbitHandler
    public void process(String message){
        try {
            System.out.println("rabbit_info_message-->" + message);
        }catch (Exception e){
            logger.info(message+"消息报错内容为-->{}"+e.getMessage());
        }
    }
}
