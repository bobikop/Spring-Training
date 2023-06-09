package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com",name="USER-CLIENT")
public interface UserClient {

    @GetMapping("/users")
    List<User> getUsers();

}
// whenever in our application we use getUsers method. Method will hit base URL
// https://jsonplaceholder.typicode.com and add @GetMapping("/users") so this endpoint will be executed with getMapping
