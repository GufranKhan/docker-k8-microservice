package com.mohd.khan.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Configuration
@Slf4j
public class FallBackConfiguration {
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction() {
		return RouterFunctions
				.route(RequestPredicates.GET("/user-fallback"), this::handleUserGetFallback)
				.andRoute(RequestPredicates.POST("/user-fallback"), this::handleUserPostFallback)
				.andRoute(RequestPredicates.GET("/department-fallback"), this::handleDepartmentGetFallback)
				.andRoute(RequestPredicates.POST("/department-fallback"), this::handleDepartmentPostFallback);
	}
	
	public Mono<ServerResponse> handleUserGetFallback(ServerRequest request) {
		log.info("handleUserGetFallback");
		return ServerResponse.ok().body(Mono.empty(), String.class);
	}
	
	public Mono<ServerResponse> handleUserPostFallback(ServerRequest request) {
	    log.info("handleUserPostFallback");
		return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
	}
	
	public Mono<ServerResponse> handleDepartmentGetFallback(ServerRequest request) {
	    log.info("handleDepartmentGetFallback");
		return ServerResponse.ok().body(Mono.empty(), String.class);
	}
	
	public Mono<ServerResponse> handleDepartmentPostFallback(ServerRequest request) {
	    log.info("handleDepartmentPostFallback");
		return ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).build();
	}

}
