package lee.garden.resilience4jdemo.controller;

import lee.garden.resilience4jdemo.service.ServiceA;
import lee.garden.resilience4jdemo.service.ServiceB;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final ServiceA serviceA;
    private final ServiceB serviceB;

    @GetMapping("/annotation")
    public Mono<String> testAnnotation(String key) {
        return serviceA.getMonoData(key);
    }

    @GetMapping("/operator")
    public Mono<String> testOperator(String key) {
        return serviceB.getMonoData(key);
    }
}
