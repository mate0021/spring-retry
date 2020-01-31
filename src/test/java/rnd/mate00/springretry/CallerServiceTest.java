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
    public void shouldCallRecover() {
        try {
            callerService.callRetriableService();
        } catch (TypeOneException | TypeTwoException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void noNeedForRecoveryCall() {
        try {
            callerService.successfullCall();
        } catch (TypeOneException e) {
            e.printStackTrace();
        }
    }
}