package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.MyEntity;
import reactor.core.publisher.Mono;
@Service
public class ValidationService {

    public Mono<MyEntity> validateEntity(MyEntity entity) {
        if (entity.getName() == null || entity.getName().isEmpty()) {
            return Mono.error(new IllegalArgumentException("Entity name is required"));
        }
        // Add more validations as needed
        return Mono.just(entity);
    }
}
