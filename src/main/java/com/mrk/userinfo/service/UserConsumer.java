package com.mrk.userinfo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {
	
	 @KafkaListener(
	            topics = "user-topic",
	            groupId = "userinfo-group")
	public void consume(String message) {
		System.out.println(
                "Received Message : "
                        + message);
	}

}
