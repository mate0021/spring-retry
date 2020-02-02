package rnd.mate00.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class RetryByTemplate {

    @Autowired
    private RetryTemplate retryTemplate;

    String doSomething() throws TypeOneException {
        String result = retryTemplate.execute(
                (RetryCallback<String, TypeOneException>) retryContext -> "do with retry",
                retryContext -> "tried hard, but needs to recover");

        return result;
    }
}
