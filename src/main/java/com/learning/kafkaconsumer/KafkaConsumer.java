package com.learning.kafkaconsumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Value("${spring.kafka.consumer.topics}")
    private String topic;

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topics}'}",
            groupId = "#{'${spring.kafka.consumer.group-id}'}")
    public void listen(ConsumerRecord<String, String> record,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        // Process the message
        System.out.println("Received message: " + record.value());
        // Print offset details
        System.out.println("Offset: " + offset);
        System.out.println("Partition: " + partition);
        System.out.println("Topic: " + topic);
        System.out.println("-----------------------------------------------------------------");
    }

}
