package com.example.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.example.model.MyEntity;

@Repository
public interface MyEntityRepository extends ReactiveMongoRepository<MyEntity, String> {
	// You can define custom queries if needed, but the basic CRUD operations are
	// handled
}
