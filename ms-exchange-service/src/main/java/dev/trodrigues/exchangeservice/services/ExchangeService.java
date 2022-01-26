package dev.trodrigues.exchangeservice.services;

import dev.trodrigues.exchangeservice.dtos.ExchangeDto;

import java.math.BigDecimal;

public interface ExchangeService {

    ExchangeDto convert(BigDecimal amount, String from, String to);

}
