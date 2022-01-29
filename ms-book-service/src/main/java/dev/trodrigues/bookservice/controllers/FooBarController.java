package dev.trodrigues.bookservice.controllers;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class FooBarController {

    private final Logger logger = LoggerFactory.getLogger(FooBarController.class);

    @GetMapping("/foo-bar")
    // @Retry(name = "foo-bar", fallbackMethod = "fallbackMethod")
    // @CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
    // @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String fooBar() {
        logger.info("Request to foo-bar is received");
        // var response = new
        // RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
        // return response.getBody();
        return "foo-bar!!";
    }

    public String fallbackMethod(Exception ex) {
        logger.info("FALLBACK");
        return "fallbackMethod foo-bar!!!!!!";
    }

}
