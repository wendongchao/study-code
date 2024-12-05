package com.example.service.impl;

import com.example.entity.User;
import com.example.event.UserEvent;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * @auther wendongchao
 * @date 2024/12/1 23:54
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public String saveMoney(String anme, int money) {
        eventPublisher.publishEvent(new UserEvent(this, anme, money));
        return "success";
    }

    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }


}
