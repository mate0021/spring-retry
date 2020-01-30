package rnd.mate00.springretry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallerService {

    @Autowired
    private RetryService retryService;

    void callRetriableService() throws TypeOneException, TypeTwoException {
        retryService.retry();
    }
}
