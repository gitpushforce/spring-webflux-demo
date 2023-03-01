package com.masaki.webfluxdemo.service;

import com.masaki.webfluxdemo.dto.MultiplyRequestDto;
import com.masaki.webfluxdemo.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {
    public Mono<Response> findSquare(int input) {
        return Mono.fromSupplier(() -> input * input)
                //.map(v -> new Response(v)); // can be replaced for .map(Response::new)
                .map(Response::new);
    }

    public Flux<Response> multiplicationTable(int input) {
        return Flux.range(1, 10)
                //.doOnNext(i -> SleepUtil.sleepSeconds(1))
                .delayElements(Duration.ofSeconds(1))  // with this kinda delay the process will be cancelled if user closes browser
                .doOnNext(i -> System.out.println("reactive service processing: " + i))
                .map(i -> new Response(i * input));
    }

    public Mono<Response> multiply(Mono<MultiplyRequestDto> dtoMono){
        return dtoMono
                .map(dto -> dto.getFirst() * dto.getSecond())
                .map(Response::new);
    }
}
