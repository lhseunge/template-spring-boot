package com.practice.template.domain.user.service;

import com.practice.template.domain.user.dto.UserInfo;
import com.practice.template.domain.user.entity.User;
import com.practice.template.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserInfo> getUsers() {
        return userRepository.findAll().stream()
                .map(UserInfo::from)
                .toList();
    }

    @Override
    public UserInfo getUserById(Long id) {

        User userInfo = userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found"));

        return UserInfo.from(userInfo);

    }
}
