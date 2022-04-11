package com.example.demo.jmsHandler;

import com.example.demo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class JMSHandler {

    private JmsTemplate jmsTemplate;

    @Autowired
    public JMSHandler(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }


    public String sendJmsMessage(Product product){
        jmsTemplate.convertAndSend("meritBox", product);
        return "hopefully sent";
    }
}
