package com.microservices.demo.twitter2kafka.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "twitter-to-kafka-service")
public class TwitterToKafkaConfig {

	private List<String> twitterKeywords;

	private String welcomeMessage;

}
