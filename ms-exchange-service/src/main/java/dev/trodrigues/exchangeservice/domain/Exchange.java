package dev.trodrigues.exchangeservice.domain;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_exchange")
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency")
    private String from;

    @Column(name = "to_currency")
    private String to;
    private BigDecimal conversionFactor;

    public Exchange() {
    }

    public Exchange(Long id, String from, String to, BigDecimal conversionFactor) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionFactor = conversionFactor;
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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Exchange other = (Exchange) obj;
        return Objects.equals(id, other.id);
    }

}
