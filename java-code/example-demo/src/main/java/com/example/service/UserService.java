package com.example.service;


import com.example.entity.User;

import java.util.List;

/**
 * @auther wendongchao
 * @date 2024/12/1 23:54
 **/
public interface UserService {
    String saveMoney(String anme, int money);

    List<User> selectAllUser();

    User selectUserById(Long id);

}
