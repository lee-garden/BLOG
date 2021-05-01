package lee.garden.resilience4jdemo.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lee.garden.resilience4jdemo.api.TestApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Slf4j
@Service
public class ServiceA {

    private final TestApi apiA;

    @CircuitBreaker(name = "garden", fallbackMethod = "fallback")
    public Mono<String> getMonoData(String key) {
        return apiA.getApiData(key);
    }

    public Mono<String> fallback(String key, Throwable t) {
        log.error("Fallback : " + t.getMessage());
        return Mono.just("fallback data");
    }
}
