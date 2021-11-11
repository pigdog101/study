package com.mzw.rabbit.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
//@RabbitListener(queues = RabbitConfig.QUEUE_A)
//@Component
public class MsgReceiver {
    private final Logger logger = LoggerFactory.getLogger(MsgReceiver.class);
    @RabbitHandler
    //@RabbitListener(queues = RabbitConfig.QUEUE_A)
    public void receiveMessage(String message){
        logger.info(message);
    }
}
