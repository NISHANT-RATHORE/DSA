package com.example.security.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    @GetMapping("/")
    public String greet(){
        return "hello Nishika Roy";
    }
}
