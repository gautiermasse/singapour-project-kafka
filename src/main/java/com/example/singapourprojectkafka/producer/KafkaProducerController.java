package com.example.singapourprojectkafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaProducerController {

    private KafkaProducer kafkaProducer;

    public KafkaProducerController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message,@RequestParam("topic") String topic,@RequestParam("key") String key,@RequestParam("value") String value){


        ProducerRecord<String, String> record = new ProducerRecord<>(topic,key ,value );

        kafkaProducer.sendMessageKeyValue(record);

        return ResponseEntity.ok("Message sent to kafka topic");
    }

    // Set up key value message


}
