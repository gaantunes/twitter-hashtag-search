package com.twitter.search.repository;

import org.springframework.stereotype.Repository;

import com.twitter.search.model.SimpleTweet;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface SimpleTweetRepository extends MongoRepository<SimpleTweet, String>{

	public List<SimpleTweet> findByUser(String user);

}
