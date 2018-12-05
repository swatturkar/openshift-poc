//package com.pyramidsystems.oc.intake.events.producer;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.jms.core.JmsTemplate;
//
//
//public class MessageSender {
//
//    @Value("${activemq.queue}")
//    private String queueName;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSender.class);
//    @Autowired
//    private JmsTemplate jmsTemplate;
//
//    public void send( String message) {
//        jmsTemplate.convertAndSend(queueName, message);
//    }
//}
