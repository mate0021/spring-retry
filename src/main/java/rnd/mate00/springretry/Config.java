package rnd.mate00.springretry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class Config {

    @Bean
    public RetryTemplate retryTemplate() {
        return new RetryTemplate();
    }
}
