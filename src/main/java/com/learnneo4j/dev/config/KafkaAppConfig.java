package com.learnneo4j.dev.config;

import com.learnneo4j.dev.model.Person;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaAppConfig {
    @Bean
    public ConsumerFactory<String, Person> consumerFactory(){
        Map<String, Object> kafkaConfig = new HashMap<>();

        kafkaConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        kafkaConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "example_topic_graph_grp");
        kafkaConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        kafkaConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        //kafkaConfig.put(JsonDeserializer.TRUSTED_PACKAGES, "com.learncassandra.dev.model");

        return new DefaultKafkaConsumerFactory<>(kafkaConfig, new StringDeserializer(),
                new ErrorHandlingDeserializer<>(new JsonDeserializer<>(Person.class, false)));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Person> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Person> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
