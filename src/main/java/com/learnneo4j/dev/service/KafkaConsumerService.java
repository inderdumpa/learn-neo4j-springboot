package com.learnneo4j.dev.service;


import com.learnneo4j.dev.model.Person;

public interface KafkaConsumerService {
    public void readMessage(Person person);
}
