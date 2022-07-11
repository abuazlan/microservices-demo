package com.microservices.demo.twitter2kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import twitter4j.Status;
import twitter4j.StatusAdapter;

@Component
public class TwitterKafkaStatusListner extends StatusAdapter{

	private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStatusListner.class);
	@Override
	public void onStatus(Status status) {
		LOG.info("Twitter Status with text {}",status.getText());
	}
}
