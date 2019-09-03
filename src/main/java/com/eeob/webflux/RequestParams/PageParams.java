package com.eeob.webflux.RequestParams;

import org.springframework.web.reactive.function.server.ServerRequest;

public class PageParams {
    public static Page Request(ServerRequest request){
        Integer page = Integer.valueOf( request.queryParam("page").orElse("1"));
        Integer rows = Integer.valueOf(request.queryParam("rows").orElse("5"));
        return new Page(rows,page);
    }
    public static class Page{
        public Integer rows;
        public Integer page;

        public Page(Integer rows, Integer page) {
            this.rows = rows;
            this.page = page;
        }
    }
}
