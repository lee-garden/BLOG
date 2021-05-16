package lee.garden.routermaster;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class PostHandler {

    /**
     * 이번 프로젝트의 주제는 router의 이해이므로
     * 로직은 최대한 간단하게 해서 결과만 받아 볼 수 있도록 구현
     * */

    // path variable 추출
    public Mono<ServerResponse> getById(ServerRequest request) {
        Long id = Long.parseLong(request.pathVariable("id"));
        Post post = new Post(id, "garden", "hello");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(post);
    }

    // x-www-form-urlencoded 추출
    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<MultiValueMap<String, String>> formData = request.formData();

        return formData.flatMap(data -> {
            Map<String, String> dataMap = data.toSingleValueMap();
            String title = dataMap.getOrDefault("title", null);
            String content = dataMap.getOrDefault("content", null);

            Post newPost = new Post(1L, title, content);
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(newPost);
        });
    }

    // json data 추출
    public Mono<ServerResponse> createFromJson(ServerRequest request) {
        Mono<Post> PostMono = request.bodyToMono(Post.class);
        return PostMono.flatMap(post ->
                ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(post));
    }

}
