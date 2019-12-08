package com.twitter.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

@Service
public class TwitterSearchService {
	
	@Autowired
	Twitter twitter;
	
	@Autowired
	SimpleTweetService simpleTweetService;
		
	public List<Tweet> getTweetsByHashtag(String hashTag, int pageSize)
	{
		List<Tweet> tweets = twitter.searchOperations().search(hashTag, pageSize).getTweets();	
		
		for(int i = 0; i < tweets.size(); i++)
		{
			simpleTweetService.saveTweet(tweets.get(i));
		}
		
		return tweets;
	}

}
