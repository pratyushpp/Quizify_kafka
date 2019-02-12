package com.stackroute.springbootkafkaproducer.config;

import com.stackroute.springbootkafkaproducer.domain.User;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {
    @Bean
    public ProducerFactory<String , User> producerFactory()
    {

        Map<String, Object> config=new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092"); //Different configs we need to provide .9092 port is for consuming messages
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);    //mention the serialization class which we gonna use as a key.what type of key going to put
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class); //this will tell kafka that we are using json config for values.we r producing json message

        return new DefaultKafkaProducerFactory<>(config);
    }
    @Bean
    public KafkaTemplate< String, User> kafkaTemplate()
    {
        return  new KafkaTemplate<>(producerFactory());
    }

}
