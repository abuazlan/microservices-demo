package com.microservices.demo.twitter2kafka;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.demo.twitter2kafka.config.TwitterToKafkaConfig;

@SpringBootApplication
public class TwitterToKafkaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TwitterToKafkaApplication.class);
	private TwitterToKafkaConfig config;

	public TwitterToKafkaApplication(TwitterToKafkaConfig config) {
		this.config = config;
	}

	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("App started");
		logger.info(config.getTwitterKeywords().toString());

	}

}
