package com.example.event;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @auther wendongchao
 * @date 2024/12/3 18:05
 **/
@Component
public class UserEventListener {

    @Order(0)
    @TransactionalEventListener(classes = UserEvent.class, phase = TransactionPhase.AFTER_COMMIT, condition = "#event.name == 'wdc'")
    public void onApplicationEvent(UserEvent event) {
        String name = event.getName();
        Integer money = event.getMoney();
        System.out.println("用户" + name + "消费了" + money + "元");
    }
}
