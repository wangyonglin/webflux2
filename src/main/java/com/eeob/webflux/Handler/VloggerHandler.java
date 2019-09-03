package com.eeob.webflux.Handler;



import com.eeob.webflux.Entity.Vlogger;
import com.eeob.webflux.Repository.VloggerRepository;

import com.eeob.webflux.RequestParams.PageParams;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
@Slf4j
public class VloggerHandler {
    private static final Logger log = LoggerFactory.getLogger(VloggerHandler.class);
    private static  Sort DatetimeDesc= new Sort(Sort.Order.desc("Datetime"));
    private final VloggerRepository repository;
    @Autowired
    public VloggerHandler(VloggerRepository repository) {
        this.repository = repository;
    }

    public Mono<ServerResponse> createVlogger(ServerRequest request) {
        Mono<Vlogger> vloggerMono =request.bodyToMono(Vlogger.class);
        return ServerResponse.ok().build(repository.insert(vloggerMono).then());
    }
    public Mono<ServerResponse> allVlogger(ServerRequest request) {
        Flux<Vlogger>vloggerFlux=  repository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(vloggerFlux,Vlogger.class);
    }
    public Mono<ServerResponse> findByCategories(ServerRequest request) {
        String keywords= String.valueOf(request.queryParam("keywords").orElse(""));
        PageParams.Page page= PageParams.Request(request);
        Flux<Vlogger> vloggerFlux= repository.findByCategories(Mono.just(keywords),new PageRequest(page.page,page.rows,DatetimeDesc));
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(vloggerFlux, Vlogger.class);
    }
}
