package com.mrk.userinfo.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserProducer {

	@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

  /*  public UserProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }  */

    public void sendMessage(String topic, Object message) {
        kafkaTemplate.send(topic, message);
    }
}