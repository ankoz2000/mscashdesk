package com.example.demo.controller;

import com.example.demo.TransactionData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class MainController {

    private final String topic = "mscashdesc";

    private ObjectMapper om;
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MainController(ObjectMapper om, KafkaTemplate<String, String> kafkaTemplate) {
        this.om = om;
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send")
    public void startTransaction(@RequestBody TransactionData transactionData) throws JsonProcessingException {
        kafkaTemplate.send(topic, om.writeValueAsString(transactionData));
    }

    @GetMapping("/get")
    public String get() {
        return "hello";
    }
}
