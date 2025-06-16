package com.practice.template.domain.user.service;

import com.practice.template.domain.user.dto.UserInfo;

import java.util.List;

public interface UserService {

    List<UserInfo> getUsers();

    UserInfo getUserById(Long id);
}
