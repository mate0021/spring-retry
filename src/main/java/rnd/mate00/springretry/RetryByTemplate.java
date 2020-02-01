package rnd.mate00.springretry;

import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class RetryByTemplate {

    String doSomething() throws Throwable {
        RetryTemplate retryTemplate = new RetryTemplate();
        String result = retryTemplate.execute(new RetryCallback<String, Throwable>() {
            @Override
            public String doWithRetry(RetryContext retryContext) throws Throwable {
                return "do with retry";
            }
        }, new RecoveryCallback<String>() {
            @Override
            public String recover(RetryContext retryContext) throws Exception {
                return "from recover";
            }
        });

        return result;
    }
}
