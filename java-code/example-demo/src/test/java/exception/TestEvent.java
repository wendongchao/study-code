package exception;

import com.example.ExampleApplication;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther wendongchao
 * @date 2024/12/5 20:39
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestEvent {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        String param = userService.saveMoney("wdc", 100);
        System.out.println(param);
    }
}
