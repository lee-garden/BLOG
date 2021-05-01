package lee.garden.resilience4jdemo.api;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class TestApi {

    private WebClient webClient;

    TestApi() {
        webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
    }

    public Mono<String> getApiData(String key) {
        return webClient.get()
                .uri("/data?key=" + key)
                .retrieve()
                .bodyToMono(String.class);
    }
}
