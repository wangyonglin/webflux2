package com.eeob.webflux.Repository;
import com.eeob.webflux.Entity.Vlogger;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@Primary
public interface VloggerRepository extends ReactiveMongoRepository<Vlogger,String> {

    @Query("{ 'Categories': ?0}")
    Flux<Vlogger>  findByCategories(Mono<String> categories,  Pageable pageable);
}
