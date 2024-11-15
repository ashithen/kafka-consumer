package com.learning.kafkaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("topic") String topic,
                                              @RequestParam("count") int count) {
        for (int i=0; i<count; i++) {
            kafkaMessageProducer.sendMessage(topic, "Test Message");
        }
        return ResponseEntity.ok(topic+" Message sent successfully");
    }
}
