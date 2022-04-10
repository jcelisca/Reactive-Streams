package com.sofka.ReactiveStreams;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class UppercaseConverterTest {

    final TestPublisher<String> testPublisher = TestPublisher.create();

    @Test
    void testUpperCase() {
        UppercaseConverter uppercaseConverter = new UppercaseConverter(testPublisher.flux());
        StepVerifier.create(uppercaseConverter.getUpperCase())
                .then(() -> testPublisher.emit("datos", "GeNeRaDoS", "Sofka"))
                .expectNext("DATOS", "GENERADOS", "SOFKA")
                .verifyComplete();
    }
}
