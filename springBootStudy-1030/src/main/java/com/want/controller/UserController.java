package com.want.controller;
 
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.want.entity.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    Map<Long, User> users = new HashMap<>();

    @PostConstruct//依赖关系注入完成之后，执行初始化
    public void init() throws Exception {
        users.put(Long.valueOf(1), new User(1, "longzhonghua", 28));
        users.put(Long.valueOf(2), new User(2, "longzhiran", 2));
    }

    @GetMapping("/list")
    public Flux<User> getAll() {
        return Flux.fromIterable(users.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable Long id) {
        return Mono.justOrEmpty(users.get(id));
    }

    @PostMapping("/addUser")
    public Mono<ResponseEntity<String>> addUser(User user) {
        users.put(user.getId(), user);
        return Mono.just(new ResponseEntity<>("添加成功", HttpStatus.CREATED));
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<User>> putUser(@PathVariable Long id, User user) {
        user.setId(id);
        users.put(id, user);
        return Mono.just(new ResponseEntity<>(user, HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteUser(@PathVariable Long id) {
        users.remove(id);
        return Mono.just(new ResponseEntity<>("删除成功", HttpStatus.ACCEPTED));
    }
}