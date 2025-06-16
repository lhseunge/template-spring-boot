package com.practice.template.domain.user.dto;

import com.practice.template.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserInfo {

    private long id;
    private String name;
    private String email;
    private String phone;

    public static UserInfo from(User user) {
        return new UserInfo(user.getId(), user.getName(), user.getEmail(), user.getPhone());
    }

}
