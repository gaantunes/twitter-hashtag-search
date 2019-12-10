package com.twitter.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.social.twitter.api.Tweet;

import com.twitter.search.model.SimpleTweet;
import com.twitter.search.service.SimpleTweetService;
import com.twitter.search.service.TwitterSearchService;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
public class TwitterSearchController {
	
	@Autowired
	TwitterSearchService service;
	
	@Autowired
	SimpleTweetService simpleTweetService;
	
	@GetMapping(value = "/tweets/{hashTag}/{pageSize}")
	public List<Tweet> getTweetsByHashtag(@PathVariable String hashTag, @PathVariable int pageSize)
	{	
		return service.getTweetsByHashtag(hashTag, pageSize);
	}
	
	@GetMapping(value = "/tweets/historical/{user}")
	public List<SimpleTweet> getHistoricalTweetsByUser(@PathVariable String user)
	{	
		return simpleTweetService.getSimpleTweetsHistoryByUser(user);
	}

}
