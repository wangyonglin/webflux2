package com.eeob.webflux.Routes;

import com.eeob.webflux.Handler.VloggerHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class VloggerRoutes {
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> vloggerRoutesFunction(VloggerHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.POST("/vlogger/create")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        handler::createVlogger)
                .andRoute(RequestPredicates.GET("/vlogger/categories")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        handler::findByCategories);


    }
}
