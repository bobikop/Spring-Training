package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {

    // will use this URI in order to consume it
    private final String URI = "https://jsonplaceholder.typicode.com/users";

    private final RestTemplate restTemplate;

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]> readAllUsers(){

        return restTemplate.getForEntity(URI, User[].class);
    }

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id){

        // based on ID show me certain user - that is our URI represent bellow
        String URL = URI + "/{id}";

        // consume and return ---- here we are using getForObject method.
        // for getForObject we do not any DTO. In use getForEntity and getForObject have difference in that with
        // getForEntity we can modify it with Jackson annotation but with getForObject we get it however is looking and consume it
        return restTemplate.getForObject(URL, Object.class,id);

    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){

        // first we create (we set) headers by using below listed syntax
        // we need to set headers for security reasons so we can have access
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        // we set the header with fallowing code (entity)
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // to past the headers we can use exchange method.
        // exchange method request fallowing paramethers listed in syntax bellow
        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

    }

}

// we used three methods
// getForEntity - if we have DTO and want to convert it to output
// getForObject - no DTO we just take it and use it
// exchange - to past the headers