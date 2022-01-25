package dev.trodrigues.greetingservice.controllers;

import dev.trodrigues.greetingservice.configs.GreetingConfig;
import dev.trodrigues.greetingservice.domain.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/")
public class GreetingController {

    private static final String TEMPLATE = "%s, %s";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingConfig greetingConfig;

    public GreetingController(GreetingConfig greetingConfig) {
        this.greetingConfig = greetingConfig;
    }

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(defaultValue = "") String name) {
        if (name.isBlank())
            name = greetingConfig.getDefaultValue();

        return new Greeting(counter.incrementAndGet(), String.format(TEMPLATE, greetingConfig.getGreeting(), name));
    }

}
