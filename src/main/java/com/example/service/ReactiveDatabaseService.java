package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Service;

import com.example.model.MyEntity;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveDatabaseService {

	@Autowired
	private ReactiveMongoTemplate reactiveMongoTemplate;

	public Mono<MyEntity> findById(String id) {
		return reactiveMongoTemplate.findById(id, MyEntity.class);
	}

	public Flux<MyEntity> findAll() {
		return reactiveMongoTemplate.findAll(MyEntity.class);
	}
}
