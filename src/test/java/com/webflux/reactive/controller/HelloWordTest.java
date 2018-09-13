package com.webflux.reactive.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class HelloWordTest {

    @Test
    public void sum() {

        WebClient client = WebClient.create("http://localhost:8080");

        Mono<String> result = client.get()
                .uri("/math/sum?values=12,12121212,12,12,121,21,21,212,1212,121212,1122,12121,3,33,333,333,3333,3")
                .accept(MediaType.APPLICATION_STREAM_JSON)
                .exchange()
                .flatMap(response -> response.bodyToMono(String.class));

        result.subscribe(System.out::println);
    }
}