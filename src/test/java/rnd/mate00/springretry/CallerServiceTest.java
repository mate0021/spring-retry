package rnd.mate00.springretry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CallerServiceTest {

    @Autowired
    private CallerService callerService;

    @Test
    public void test() {
        try {
            callerService.callRetriableService();
        } catch (TypeOneException e) {
            e.printStackTrace();
        } catch (TypeTwoException e) {
            e.printStackTrace();
        }
    }
}