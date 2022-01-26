package dev.trodrigues.bookservice.services.impl;

import dev.trodrigues.bookservice.dtos.BookDto;
import dev.trodrigues.bookservice.proxies.ExchangeProxy;
import dev.trodrigues.bookservice.repositories.BookRepository;
import dev.trodrigues.bookservice.services.BookService;
import dev.trodrigues.bookservice.services.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ExchangeProxy exchangeProxy;

    public BookServiceImpl(BookRepository bookRepository, ExchangeProxy exchangeProxy) {
        this.bookRepository = bookRepository;
        this.exchangeProxy = exchangeProxy;
    }

    @Override
    public BookDto getBookById(Long id, String currency) {
        var book = this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found " + id));
        var exchange = exchangeProxy.getExchange(book.getPrice(), "USD", currency);
        var bookDto = new BookDto(book);
        bookDto.setPrice(exchange.getConvertedValue());
        bookDto.setCurrency(currency);
        return bookDto;
    }

}
