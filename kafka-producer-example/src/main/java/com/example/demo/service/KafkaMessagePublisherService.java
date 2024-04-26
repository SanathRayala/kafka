package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessagePublisherService {
	@Autowired
	private KafkaTemplate<String, Object> template;

	public void sendMessageToTopic(String message) {
		CompletableFuture<SendResult<String, Object>> completableFuture = template.send("TopicSB", message);
		completableFuture.whenComplete((res, ex) -> {
			if (ex == null)
				System.out.println(message + ":offset->" + res.getRecordMetadata().offset() + ":patition@"
						+ res.getRecordMetadata().partition()+"-->"+LocalDateTime.now());
			else
				System.out.println("Exception Due to " + ex.getMessage());
		});
	}
}
