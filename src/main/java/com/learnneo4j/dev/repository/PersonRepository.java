package com.learnneo4j.dev.repository;

import com.learnneo4j.dev.model.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person, Long> {
}
