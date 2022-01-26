package dev.trodrigues.exchangeservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.trodrigues.exchangeservice.domain.Exchange;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeDto {
    private Long id;
    private String from;
    private String to;
    private BigDecimal conversionFactor;
    private BigDecimal convertedValue;
    private String environment;

    public ExchangeDto(Exchange exchange, BigDecimal amount) {
        this.id = exchange.getId();
        this.from = exchange.getFrom();
        this.to = exchange.getTo();
        this.conversionFactor = exchange.getConversionFactor();
        this.convertedValue = convertAmount(amount).setScale(2, RoundingMode.UP);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public BigDecimal convertAmount(BigDecimal amount) {
        return this.conversionFactor.multiply(amount);
    }

}
