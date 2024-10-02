package com.example.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ReactiveService {

    public Mono<String> processRequest() {
        return Mono.just("Data fetched after delay")
                   .map(response -> {
                       simulateDelay();
                       return response;
                   });
    }

    private void simulateDelay() {
        try {
            Thread.sleep(1000); // Simulate blocking I/O (not recommended for actual non-blocking)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
