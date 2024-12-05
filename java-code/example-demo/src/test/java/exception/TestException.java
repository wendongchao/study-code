package exception;

import com.example.ExampleApplication;
import com.example.config.MyUncaughtExceptionHandler;
import com.example.config.SpringTreadPoolManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @auther wendongchao
 * @date 2024/11/25 18:06
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExampleApplication.class)
public class TestException {

    @Autowired
    private SpringTreadPoolManager springTreadPoolManager;

    @Test
    public void test01() {
        ThreadPoolTaskExecutor executor = springTreadPoolManager.getThreadPoolTaskExecutor();
        executor.execute(() -> {
            int i = 1 / 0;
        });
        executor.shutdown();
    }

    @Test
    public void test02() {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//        executor.execute(() -> {
//            int i = 1 / 0;
//        });
        Thread thread = new Thread(() -> {
            int i = 1 / 0;
        });
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        thread.start();
    }


}
