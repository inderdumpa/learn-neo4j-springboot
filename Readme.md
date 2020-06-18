# Getting Started

This is a Spring boot service to consume a kafka json message. The consumed message is stored in Neo4j graph db.

This service also has end points to query the graph db.

## Building
Dependencies:
- Java 11
- Maven
- Kafka
- Zookeeper
- Neo4j
- Docker

Build:
```$xslt
mvn clean install
```
Run:
```$xslt
cd target
java -jar learn-neo4j-springboot-0.0.1-SNAPSHOT.jar
```
### Service Endpoints
- GET: http://localhost:8083/api/v1/graph/person/all
- GET: http://localhost:8083/api/v1/graph/person/{name}

### Installing Neo4j using Docker
```$xslt
docker run --publish=7474:7474 --publish=7687:7687 neo4j:4.0.5
```
Querying the DB:
```$xslt
neo4j@neo4j> MATCH(p:Person) RETURN p;
+-------------------------------------------------------+
| p                                                     |
+-------------------------------------------------------+
| (:Person {name: "Tom", email: "tom@somecompany.com"}) |
| (:Person {name: "Sam", email: "sam@somecompany.com"}) |
+-------------------------------------------------------+

2 rows available after 125 ms, consumed after another 1 ms
```