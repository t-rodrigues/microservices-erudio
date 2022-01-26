package dev.trodrigues.exchangeservice.controllers;

import dev.trodrigues.exchangeservice.dtos.ExchangeDto;
import dev.trodrigues.exchangeservice.services.ExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("exchange-service")
public class ExchangeController {

    private final Environment environment;
    private final ExchangeService exchangeService;

    public ExchangeController(Environment environment, ExchangeService exchangeService) {
        this.environment = environment;
        this.exchangeService = exchangeService;
    }

    @GetMapping("/{amount}/{from}/{to}")
    public ExchangeDto getExchange(@PathVariable BigDecimal amount, @PathVariable String from,
            @PathVariable String to) {
        var exchangeDto = this.exchangeService.convert(amount, from, to);
        var port = environment.getProperty("local.server.port");
        exchangeDto.setEnvironment(port);

        return exchangeDto;
    }

}
