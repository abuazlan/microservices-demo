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

	public List<String> getTwitterKeywords() {
		return twitterKeywords;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public void setTwitterKeywords(List<String> twitterKeywords) {
		this.twitterKeywords = twitterKeywords;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

}
