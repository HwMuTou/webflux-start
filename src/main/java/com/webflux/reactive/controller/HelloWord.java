package com.webflux.reactive.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.stream.IntStream;

@RestController
@RequestMapping("/math")
public class HelloWord {

    @GetMapping("/sum")
    public Mono<Integer> sum(@RequestParam int[] values) {
        return Mono.just(IntStream.of(values).sum());
    }
}
