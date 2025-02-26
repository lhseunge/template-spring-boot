package com.practice.template.domain.user.service;

import com.practice.template.domain.user.entity.User;
import com.practice.template.domain.user.repository.UserRepository;
import com.practice.template.domain.user.dto.UserResponse;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.practice.template.domain.user.entity.QUser.user;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponse::from)
                .toList();
    }

    @Override
    public UserResponse getUserById(Long id) {

        User userInfo = queryFactory.selectFrom(user)
                .where(user.id.eq(id))
                .fetchOne();

        if (userInfo == null) {
            throw new RuntimeException("user not found");
        }

        return UserResponse.from(userInfo);

    }
}
