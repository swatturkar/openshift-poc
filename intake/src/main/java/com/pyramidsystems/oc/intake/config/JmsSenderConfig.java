//package com.pyramidsystems.oc.intake.config;
//
//import com.pyramidsystems.oc.intake.events.producer.MessageSender;
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.connection.CachingConnectionFactory;
//import org.springframework.jms.core.JmsTemplate;
//
//@Configuration
//public class JmsSenderConfig {
//    @Value("${activemq.broker-url}")
//    private String brokerUrl;
//
//    @Bean
//    public ActiveMQConnectionFactory activeMQConnectionFactory() {
//        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
//        activeMQConnectionFactory.setBrokerURL(brokerUrl);
//
//        return activeMQConnectionFactory;
//    }
//
//    @Bean
//    public CachingConnectionFactory cachingConnectionFactory() {
//        return new CachingConnectionFactory(activeMQConnectionFactory());
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate() {
//        return new JmsTemplate(cachingConnectionFactory());
//    }
//
//    @Bean
//    public MessageSender sender() {
//        return new MessageSender();
//    }
//}
