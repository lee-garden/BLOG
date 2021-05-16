package lee.garden.routermaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
@EnableWebFlux
public class RouterConfig {

    @Bean
    public RouterFunction<ServerResponse> routerExample(PostHandler postHandler) {
        return RouterFunctions.route()
                .GET("/post/{id}", postHandler::getById)
                .POST("/post", accept(MediaType.APPLICATION_JSON), postHandler::create)
                .POST("/post/json", accept(MediaType.APPLICATION_JSON), postHandler::createFromJson)
                .build();
    }
}
