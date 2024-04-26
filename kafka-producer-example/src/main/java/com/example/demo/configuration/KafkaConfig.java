package com.example.demo.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
	@Bean
	NewTopic createTopic() {
		return new NewTopic("TopicSB", 5, (short) 1);
	}
}
