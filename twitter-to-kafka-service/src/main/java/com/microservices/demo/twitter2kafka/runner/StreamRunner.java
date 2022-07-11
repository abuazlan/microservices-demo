package com.microservices.demo.twitter2kafka.runner;

import twitter4j.TwitterException;

public interface StreamRunner {

	public void start() throws TwitterException;
}
