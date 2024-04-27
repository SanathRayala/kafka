package kafka.consumer.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {
	Logger log = LoggerFactory.getLogger(KafkaMessageListener.class);

	@KafkaListener(topics = "TopicSB",groupId = "cwg-group-1")
	public void consume(String message) {
		log.info("Consuming the message: {}", message);
	}
}
