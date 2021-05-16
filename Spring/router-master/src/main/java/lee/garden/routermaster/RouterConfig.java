package lee.garden.routermaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

/**
 * 각 Bean을 주석 해제해 가며 테스트
 * */
@Configuration
@EnableWebFlux
public class RouterConfig {

    /**
     * 라우터 기본 방식
     * */
//    @Bean
//    public RouterFunction<ServerResponse> routerExample(PostHandler postHandler) {
//        return RouterFunctions.route()
//                .GET("/post/{id}", postHandler::getById)
//                .POST("/post", postHandler::create)
//                .POST("/post/json", accept(MediaType.APPLICATION_JSON), postHandler::createFromJson)
//                .build();
//    }

    /**
     * nested router
     * */
//    @Bean
//    public RouterFunction<ServerResponse> nestedRouter(PostHandler postHandler) {
//        return RouterFunctions.route()
//                .path("/post", builder -> builder
//                    .GET("/{id}", postHandler::getById)
//                    .POST("", postHandler::create)
//                    .POST("/json", postHandler::createFromJson)
//                ).build();
//    }

    /**
     * nested router with same condition
     * */
//    @Bean
//    public RouterFunction<ServerResponse> nestedRouter2(PostHandler postHandler) {
//        return RouterFunctions.route()
//                .path("/post", builder -> builder
//                        .nest(accept(MediaType.APPLICATION_JSON), builder2 -> builder2
//                            .POST("/json", postHandler::createFromJson)
////                            .POST("", postHandler::xxx) 이 뒤로 붙는 RequestPredicate는 모두 APPLICATION_JSON이 accept
////                            .PUT("", postHandler::xxx)
//                        )
//                ).build();
//    }

//    @Bean
//    public RouterFunction<ServerResponse> routerExample2(PostHandler postHandler) {
//        return RouterFunctions
//                .route(GET("/post"), postHandler::getById)
//                .andRoute(POST("/post").and(accept(MediaType.APPLICATION_FORM_URLENCODED)), postHandler::create)
//                .andRoute(POST("/post/json").and(accept(MediaType.APPLICATION_JSON)), postHandler::createFromJson);
//    }

}
