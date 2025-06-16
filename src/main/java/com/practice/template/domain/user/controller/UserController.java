package com.practice.template.domain.user.controller;

import com.practice.template.domain.user.dto.UserInfo;
import com.practice.template.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<UserInfo>> getUsers() {
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("users/{id}")
    public ResponseEntity<UserInfo> getUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
}
