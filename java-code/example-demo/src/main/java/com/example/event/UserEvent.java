package com.example.event;

import com.example.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @auther wendongchao
 * @date 2024/12/3 18:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEvent {
    private String name;
    private Integer money;
    private UserServiceImpl userService;

    public UserEvent(UserServiceImpl userService, String anme, int money) {
        this.userService = userService;
        this.name = anme;
        this.money = money;
    }
}
