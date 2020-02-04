package rnd.mate00.springretry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FragileService {

    private static final Logger log = LoggerFactory.getLogger(RetryService.class);

    private static int COUNTER = 0;

    public String tryToProcess() throws TypeOneException, TypeTwoException {
        COUNTER++;
        log.info("Counter value: {}", COUNTER);

        if (COUNTER == 1) {
            throw new TypeOneException();
        } else if (COUNTER == 2) {
            throw new TypeTwoException();
        }

        return "We made it!";
    }

    public String willNeverSucceed() {
        throw new RuntimeException("We couldn't make it...");
    }
}
