package com.reactivespring.controller;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinksTest {

    @Test
    void sink() {
        //given
        Sinks.Many<Integer> replaySink = Sinks.many().replay().all();

        //when
        replaySink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        replaySink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        //then
        Flux<Integer> integerFlux =  replaySink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 1: "+i);
        });

        Flux<Integer> integerFlux1 =  replaySink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 2: "+i);
        });

        replaySink.tryEmitNext(3);

        Flux<Integer> integerFlux2 =  replaySink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 3: "+i);
        });
    }

    @Test
    void sinkMulticast() {
        //given
        Sinks.Many<Integer> multicastSink = Sinks.many().multicast().onBackpressureBuffer();

        //when
        multicastSink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        multicastSink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        //then
        Flux<Integer> integerFlux =  multicastSink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 1: "+i);
        });

        Flux<Integer> integerFlux1 =  multicastSink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 2: "+i);
        });

        multicastSink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);

        Flux<Integer> integerFlux2 =  multicastSink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 3: "+i);
        });

        multicastSink.emitNext(4, Sinks.EmitFailureHandler.FAIL_FAST);
    }

    @Test
    void sinkUnicast() {
        //given
        Sinks.Many<Integer> unicastSink = Sinks.many().unicast().onBackpressureBuffer();

        //when
        unicastSink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        unicastSink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        //then
        Flux<Integer> integerFlux =  unicastSink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 1: "+i);
        });

        Flux<Integer> integerFlux1 =  unicastSink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 2: "+i);
        });

        unicastSink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);

        Flux<Integer> integerFlux2 =  unicastSink.asFlux();
        integerFlux.subscribe((i) -> {
            System.out.println("Susbcriber 3: "+i);
        });

        unicastSink.emitNext(4, Sinks.EmitFailureHandler.FAIL_FAST);
    }
}
