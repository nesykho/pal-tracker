package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class WelcomeController {

    @Value("${welcome.message}") //1. Field injection
    String hello;
    /*
    //2. Method level injection
    String hello(@Value("$.{hello.message}") String helloMessage){
*/
    public WelcomeController(@Value("${welcome.message:NOT SET}") String hello){
        this.hello = hello;
    }

    @GetMapping("/")
    public String sayHello() {
        return hello;
    }
}