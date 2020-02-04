package rnd.mate00.springretry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {

    private static final Logger log = LoggerFactory.getLogger(RetryService.class);

    private static int COUNTER = 0;

    @Autowired
    private FragileService fragileService;

    @Retryable(
            value = {TypeOneException.class, TypeTwoException.class},
            maxAttempts = 3,
            backoff = @Backoff(2000)
    )
    void retry() throws TypeOneException, TypeTwoException {
        log.info(fragileService.tryToProcess());
    }

    @Recover
    public void recover(Throwable t) {
        log.info("Recovering from {}", t.getMessage());
    }

    @Retryable(
            value = {TypeOneException.class},
            maxAttempts = 3,
            backoff = @Backoff(2000)
    )
    void retrySuccessfully() throws TypeOneException {
        log.info("First attempt");
        COUNTER++;
        if (COUNTER == 1) {
            log.info("Counter has too low value ({})!", COUNTER);
            throw new TypeOneException();
        }

        log.info("Successfully finished. No need to recover.");
    }

    @Retryable(
            value = {RuntimeException.class},
            maxAttempts = 3,
            backoff = @Backoff(1000)
    )
    void thisAintGonnaWork() {
        log.info(fragileService.willNeverSucceed());
    }
}
