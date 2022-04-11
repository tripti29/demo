package com.example.demo.jmsHandler;

import com.example.demo.Product;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    @JmsListener(destination = "meritBox", containerFactory = "myFactory")
    public void receiveMessage(Product product) {
        System.out.println("Received: " + product);
    }
}
