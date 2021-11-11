package com.mzw.rabbit;

import com.mzw.rabbit.config.MyProducer;
import com.mzw.rabbit.config.RabbitConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


@SpringBootTest
public class RabbitTests {
    @Value("${mq.config.direct.exchange}")
    private String directExchange;
    @Value("${mq.routing-key.direct.info}")
    private String directInfoRoutingKey;
    @Value("${mq.routing-key.direct.error}")
    private String directErrorRoutingKey;

    @Value("${mq.config.topic.exchange}")
    private String topicExchange;

    @Value("${mq.config.fanout.exchange}")
    private String fanoutExchange;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    MyProducer myProducer;
    private final Logger logger = LoggerFactory.getLogger(RabbitTests.class);
    @Test
    public void testRabbit(){
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.setConfirmCallback(myProducer);
        rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_A,RabbitConfig.ROUTINGKEY_A,"rabbitmq发送测试",correlationData);
    }
    @Test
    public void testCallBackSend(){
        String message = "测试消息消费回调";
        myProducer.sendMessage(message);
    }
    @Test
    public void tesrReceive(){
        String str = (String) rabbitTemplate.receiveAndConvert("QUEUE_A");
        logger.info(str);
    }

    @Test
    public void infoPrivider() throws InterruptedException {
        int n = 0;
        while(true){
            n++;
            Thread.sleep(2000);
            rabbitTemplate.convertAndSend(directExchange,directInfoRoutingKey,"info测试"+n);
        }
    }
    @Test
    public void errorPrivider(){
        rabbitTemplate.convertAndSend(directExchange,directErrorRoutingKey,"error测试");
    }

    @Test
    public void userPrivider(){
        rabbitTemplate.convertAndSend(topicExchange,"user.log.warn","user.log.warn...."+"测试topic");
        rabbitTemplate.convertAndSend(topicExchange,"user.log.info","user.log.info...."+"测试topic");
        rabbitTemplate.convertAndSend(topicExchange,"user.log.error","user.log.error...."+"测试topic");
    }

    @Test
    public void productPrivider(){
        rabbitTemplate.convertAndSend(topicExchange,"product.log.warn","product.log.warn...."+"测试topic");
        rabbitTemplate.convertAndSend(topicExchange,"product.log.info","product.log.info...."+"测试topic");
        rabbitTemplate.convertAndSend(topicExchange,"product.log.error","product.log.error...."+"测试topic");
    }

    @Test
    public void fanoutPrivider(){
        rabbitTemplate.convertAndSend(fanoutExchange,"","fanout测试");
    }
}
