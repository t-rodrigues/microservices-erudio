package dev.trodrigues.bookservice.proxies;

import dev.trodrigues.bookservice.dtos.ExchangeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exchange-service")
public interface ExchangeProxy {

    @GetMapping("/exchange-service/{amount}/{from}/{to}")
    public ExchangeDto getExchange(@PathVariable Double amount, @PathVariable String from, @PathVariable String to);

}
