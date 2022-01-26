package dev.trodrigues.exchangeservice.repositories;

import dev.trodrigues.exchangeservice.domain.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    Optional<Exchange> findByFromAndTo(String from, String to);

}
