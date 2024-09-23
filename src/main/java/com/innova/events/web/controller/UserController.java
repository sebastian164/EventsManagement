package com.innova.events.web.controller;

import com.innova.events.application.dto.UserDTO;
import com.innova.events.application.mapper.UserMapper;
import com.innova.events.application.service.UserService;
import com.innova.events.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<UserDTO> findAll() {
        return userService.findAll()
                .map(userMapper::toDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<UserDTO> findById(@PathVariable Long id) {
        return userService.findById(id)
                .map(userMapper::toDTO);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<UserDTO> save(@RequestBody UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        return userService.save(user)
                .map(userMapper::toDTO);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable Long id) {
        return userService.deleteById(id);
    }
}