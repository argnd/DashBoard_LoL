package com.hello.spring.restcontroller;

import com.hello.spring.model.HelloModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hellorest")
    public HelloModel greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloModel(counter.incrementAndGet(), String.format(template, name));
    }

}
