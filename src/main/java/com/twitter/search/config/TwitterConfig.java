package com.twitter.search.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

@Configuration
public class TwitterConfig {
	
	@Value("${spring.social.twitter.appId}")
	private String consumerKey;
	@Value("${spring.social.twitter.appSecret}")
	private String consumerSecret;

	@Bean
	TwitterTemplate getTwtTemplate()
	{	
		return new TwitterTemplate(consumerKey, consumerSecret);
	}
}
