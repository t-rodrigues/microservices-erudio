package dev.trodrigues.exchangeservice.services.impl;

import dev.trodrigues.exchangeservice.dtos.ExchangeDto;
import dev.trodrigues.exchangeservice.repositories.ExchangeRepository;
import dev.trodrigues.exchangeservice.services.ExchangeService;
import dev.trodrigues.exchangeservice.services.exceptions.CurrencyUnsupported;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;

    public ExchangeServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public ExchangeDto convert(BigDecimal amount, String from, String to) {
        var exchange = this.exchangeRepository.findByFromAndTo(from, to).orElseThrow(() -> new CurrencyUnsupported(""));
        return new ExchangeDto(exchange, amount);
    }

}
