package rnd.mate00.springretry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RetryByTemplateTest {

    @Autowired
    private RetryByTemplate retryByTemplate;

    @Test
    public void shouldUseRecoverInsteadOfCatchingException() {
        try {
            retryByTemplate.doSomething();
        } catch (TypeOneException e) {
            fail();
            e.printStackTrace();
        }
    }

}