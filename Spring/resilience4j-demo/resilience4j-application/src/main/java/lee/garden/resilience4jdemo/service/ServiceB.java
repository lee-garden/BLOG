package lee.garden.resilience4jdemo.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.reactor.circuitbreaker.operator.CircuitBreakerOperator;
import lee.garden.resilience4jdemo.api.TestApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class ServiceB {

    private final TestApi api;
    private final CircuitBreakerRegistry circuitBreakerRegistry;

    public Mono<String> getMonoData(String key) {
        CircuitBreaker circuit = circuitBreakerRegistry.circuitBreaker("garden");

        return api.getApiData(key)
                .transform(CircuitBreakerOperator.of(circuit))
                .onErrorResume(this::fallback);
    }

    public Mono<String> fallback(Throwable t) {
        log.error("Fallback : " + t.getMessage());
        return Mono.just("fallback data");
    }
}
