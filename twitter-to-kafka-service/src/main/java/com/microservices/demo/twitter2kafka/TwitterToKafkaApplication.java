package com.microservices.demo.twitter2kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.microservices.demo.twitter2kafka.config.TwitterToKafkaConfig;
import com.microservices.demo.twitter2kafka.runner.StreamRunner;

@SpringBootApplication
public class TwitterToKafkaApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(TwitterToKafkaApplication.class);
	
	@Autowired
	private TwitterToKafkaConfig config;
	
	@Autowired
	private StreamRunner streamRunner;


	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("App started");
		logger.info(config.getTwitterKeywords().toString());
		logger.info(config.getWelcomeMessage());
		streamRunner.start();
	}

}
