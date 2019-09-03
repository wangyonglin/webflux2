package com.eeob.webflux.Service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConfigsService {
    /*
    private Map<String,Configs> configsMap =new ConcurrentHashMap<>();
    public void setConfigs(String configsId,Configs configs) {
        configsMap.put(configsId,configs);
    }

    public Mono<Configs> findConfigsById(String userId){
        Configs user = configsMap.getOrDefault(userId,new Configs("app","notice","1.0.0","apk"));
        return Mono.just(user);
    }
    public Flux<Configs> findConfigsList(){
        List<Configs> userList = new ArrayList<>();
        Set<Map.Entry<String,Configs>> entries =configsMap.entrySet();
        entries.stream().forEach(entry->userList.add(entry.getValue()));
        return Flux.fromStream(userList.stream());
    }*/

}
