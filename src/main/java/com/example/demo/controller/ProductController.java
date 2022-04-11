package com.example.demo.controller;

import com.example.demo.Product;
import com.example.demo.jmsHandler.JMSHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private JMSHandler jmsHandler;

    @Autowired
    public ProductController(JMSHandler jmsHandler) {
        this.jmsHandler=jmsHandler;
    }

    @PostMapping("/product")
    public String addProduct(@RequestBody Product product){
        System.out.println("I do not have a database but I will do something.");
        return jmsHandler.sendJmsMessage(product);
    }
}
