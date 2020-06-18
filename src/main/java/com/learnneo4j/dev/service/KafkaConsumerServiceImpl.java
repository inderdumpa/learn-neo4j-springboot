package com.learnneo4j.dev.service;

import com.learnneo4j.dev.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {
    @Autowired
    private PersonService personService;
    @Override
    @KafkaListener(topics = "EXAMPLE_TOPIC", groupId = "example_topic_graph_grp", containerFactory = "kafkaListenerContainerFactory")
    public void readMessage(Person person) {
        if(person != null) {
            System.out.println("Message arrived: " + person);
            personService.savePerson(person);
            System.out.println("Person object saved to Graph DB.");
        }
    }
}
