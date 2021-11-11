package com.mzw.rabbit.config;

import com.rabbitmq.client.ConfirmCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class MyProducer implements RabbitTemplate.ConfirmCallback {
    private final Logger logger = LoggerFactory.getLogger(MyProducer.class);
    //由于rabbitTemplate的scope属性设置为ConfigurableBeanFactory.SCOPE_PROTOTYPE，所以不能自动注入
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public MyProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void sendMessage(String message){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,message,correlationData);
    }




    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        logger.info("回调id-->>{}",correlationData);
        if (b){
            logger.info("消息发送成功");
        }else {
            logger.info("消息发送失败提示-->>{}",s);
        }
    }
}
