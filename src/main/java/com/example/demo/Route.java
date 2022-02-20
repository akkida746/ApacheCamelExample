package com.example.demo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class Route extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration()
                .port(8080)
                .bindingMode(RestBindingMode.json);

        rest().get("/greeting")
                .to("/greeting");

        from("/greeting")
                .log("Getting Msg")
                .bean(String.class,greeting());
    }

    static String greeting(){
        return "Hello";
    }
}
