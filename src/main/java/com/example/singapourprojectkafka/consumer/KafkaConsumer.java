package com.example.singapourprojectkafka.consumer;

// Importing required classes
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.StringReader;

@Component

// Class
public class KafkaConsumer {

    @KafkaListener(topics = "stock-sg",
            groupId = "ddd", containerFactory = "concurrentKafkaListenerContainerFactory"
    )

    // Method
    public void
    consume_key_value(ConsumerRecord<String, String> record)
    {
        // Print statement
        System.out.println("key:"+record.key()+" value:"+record.value()+" partition:"+record.partition()+" topic:"+record.topic()+" offset:"+record.offset());

        // Parse string to json
        String str = record.value();

    }

}

