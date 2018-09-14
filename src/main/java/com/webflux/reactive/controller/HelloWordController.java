package com.webflux.reactive.controller;

import com.webflux.reactive.controller.request.body.HelloWorkParam;
import com.webflux.reactive.domian.HelloWord;
import com.webflux.reactive.repository.HelloWordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/helloWord")
public class HelloWordController {

    private HelloWordRepository helloWordRepository;

    @Autowired
    public HelloWordController(HelloWordRepository helloWordRepository) {
        this.helloWordRepository = helloWordRepository;
    }

    @GetMapping
    public Flux<HelloWord> index() {
        return helloWordRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<HelloWord> show(@PathVariable Long id) {
        return helloWordRepository.findById(id);
    }

    @PostMapping
    public Mono<HelloWord> create(@RequestBody HelloWord helloWord) {
        return helloWordRepository.save(helloWord);
    }

    @PutMapping("/{id}")
    public Mono<HelloWord> update(@RequestBody HelloWorkParam param,
                                  @PathVariable Long id) {
        Mono<HelloWord> helloWordMono = helloWordRepository.findById(id);

        return helloWordMono.flatMap(helloWord -> {
            helloWord.setValue(param.getValue());
            helloWord.setName(param.getName());
            return helloWordRepository.save(helloWord);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Long id) {
        return helloWordRepository.deleteById(id);
    }
}
