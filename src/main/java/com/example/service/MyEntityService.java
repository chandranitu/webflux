package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MyEntity;
import com.example.repository.MyEntityRepository;

import reactor.core.publisher.Mono;

@Service
public class MyEntityService {

	@Autowired
	private MyEntityRepository repository;

	public Mono<MyEntity> save(MyEntity entity) {
		return repository.save(entity);
	}

	public Mono<MyEntity> findById(String id) {
		return repository.findById(id);
	}

	public Mono<Void> deleteById(String id) {
		return repository.deleteById(id);
	}
}
