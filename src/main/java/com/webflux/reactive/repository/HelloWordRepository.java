package com.webflux.reactive.repository;

import com.webflux.reactive.domian.HelloWord;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface HelloWordRepository extends ReactiveCrudRepository<HelloWord, String> {
}