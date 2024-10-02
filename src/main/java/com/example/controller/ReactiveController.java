package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.MyEntity;
import com.example.service.MyEntityService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/entities")
public class ReactiveController {

    // Autowired service to handle MyEntity-related business logic
    @Autowired
    private MyEntityService myEntityService;

    /**
     * Non-blocking GET endpoint to return a simple string message.
     * 
     * @return Mono<String> - a reactive string response.
     */
    @GetMapping("/non-blocking")
    public Mono<String> getNonBlocking() {
        return Mono.just("Hello, this is a non-blocking response!")
                   .map(response -> response + " Processed by: " + Thread.currentThread().getName());
    }

    /**
     * Non-blocking GET endpoint to fetch an entity by its ID.
     * 
     * @param id - The ID of the entity to retrieve.
     * @return Mono<ResponseEntity<MyEntity>> - Returns the entity if found, or a 404 if not found.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<MyEntity>> getEntityById(@PathVariable String id) {
        return myEntityService.findById(id)
                              .map(entity -> ResponseEntity.ok(entity)) // Return the entity with HTTP 200 status
                              .defaultIfEmpty(ResponseEntity.notFound().build()); // Return HTTP 404 if not found
    }

    /**
     * Non-blocking PUT endpoint to update an entity with the specified ID.
     * 
     * @param id - The ID of the entity to update.
     * @param entity - The entity data to update.
     * @return Mono<ResponseEntity<MyEntity>> - Returns the updated entity or a 400 status for invalid data.
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<MyEntity>> updateEntity(@PathVariable String id, @RequestBody MyEntity entity) {
        // Ensure the entity has the correct ID before saving
        entity.setId(id);

        return myEntityService.save(entity)
                              .map(savedEntity -> ResponseEntity.ok(savedEntity)) // Return the updated entity with HTTP 200 status
                              .defaultIfEmpty(ResponseEntity.badRequest().build()); // Return HTTP 400 if invalid request
    }
}
