package com.microservices.demo.twitter2kafka.runner;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.microservices.demo.twitter2kafka.config.TwitterToKafkaConfig;
import com.microservices.demo.twitter2kafka.listener.TwitterKafkaStatusListner;

import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Component
public class TwitterStreamRunner implements StreamRunner {
	private static final Logger LOG = LoggerFactory.getLogger(TwitterStreamRunner.class);

	private TwitterKafkaStatusListner listener;
	private TwitterToKafkaConfig config;
	private TwitterStream stream;

	public TwitterStreamRunner(TwitterKafkaStatusListner listener, TwitterToKafkaConfig config) {
		super();
		this.listener = listener;
		this.config = config;
	}

	public void start() throws TwitterException {
		stream = TwitterStreamFactory.getSingleton();
		stream.addListener(listener);
		addFilter();

	}

	@PreDestroy
	public void shutdown() {
		if (stream != null)
			stream.shutdown();
		LOG.info("Shutting down Twitter Stream");
	}

	private void addFilter() {
		String keywords[] = config.getTwitterKeywords().toArray(new String[0]);
		FilterQuery query = new FilterQuery(keywords);
		stream.filter(query);
		LOG.info("Started Twitter Stream for following keywords {}", keywords);
	}

}
