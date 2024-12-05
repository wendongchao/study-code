package com.example.service.impl;

import com.example.event.UserEvent;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @auther wendongchao
 * @date 2024/12/1 23:54
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Override
    public String saveMoney(String anme, int money) {
        eventPublisher.publishEvent(new UserEvent(this, anme, money));
        return "success";
    }
}
