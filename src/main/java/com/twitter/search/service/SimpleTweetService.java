package com.twitter.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Service;

import com.twitter.search.model.SimpleTweet;
import com.twitter.search.repository.SimpleTweetRepository;

@Service
public class SimpleTweetService {
	
	@Autowired
	SimpleTweetRepository repository;
	
	public void saveTweet(Tweet tweet)
	{
		SimpleTweet simpleTweet = new SimpleTweet();
		simpleTweet.setId(tweet.getIdStr());
		simpleTweet.setCreatedAt(tweet.getCreatedAt());
		simpleTweet.setFromUser(tweet.getFromUser());
		simpleTweet.setRetweetCount(tweet.getRetweetCount());
		simpleTweet.setText(tweet.getText());
		
		repository.save(simpleTweet);
	}
	
	public List<SimpleTweet> getSimpleTweetsHistoryByUser(String user)
	{
		return repository.findByUser(user);
	}

}
