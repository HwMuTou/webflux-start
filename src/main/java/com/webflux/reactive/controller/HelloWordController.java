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

    /*TODO The stream by MediaType.APPLICATION_STREAM_JSON_VALUE like this
    * @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    * */
    @GetMapping
    public Flux<HelloWord> index() {
        return helloWordRepository.findAll();
    }

    @GetMapping("/{id}")
    public Mono<HelloWord> show(@PathVariable String id) {
        return helloWordRepository.findById(id);
    }

    @PostMapping
    public Mono<HelloWord> create(@RequestBody HelloWord helloWord) {
        return helloWordRepository.save(helloWord);
    }

    @PutMapping("/{id}")
    public Mono<HelloWord> update(@RequestBody HelloWorkParam param,
                                  @PathVariable String id) {
        return helloWordRepository
                .findById(id)
                .flatMap(helloWord -> {
                    helloWord.setValue(param.getValue());
                    helloWord.setName(param.getName());
                    return helloWordRepository.save(helloWord);
                });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return helloWordRepository.deleteById(id);
    }
}
