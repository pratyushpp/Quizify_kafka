package com.stackroute.springbootkafkadomain.controller;

import com.stackroute.springbootkafkadomain.domain.User;
import com.stackroute.springbootkafkadomain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
//@RequestMapping("kafka")

public class UserController
{
    UserService userService;
    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC="Kafka_js";
    @GetMapping("/publish/{name}")
    public String get(@PathVariable("name") final String name)
    {
        kafkaTemplate.send(TOPIC, new User(name,"Full Stack"));
        return "Publish Successful";
    }
//
    @PostMapping("/publish")
    public ResponseEntity<?> userData(@RequestBody User user)
    {
        ResponseEntity responseEntity = new ResponseEntity<User>(userService.userData(user), HttpStatus.CREATED);
        return responseEntity;
    }
}
