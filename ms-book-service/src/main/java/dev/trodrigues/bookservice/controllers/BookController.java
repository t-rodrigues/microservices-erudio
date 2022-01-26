package dev.trodrigues.bookservice.controllers;

import dev.trodrigues.bookservice.domain.Book;
import dev.trodrigues.bookservice.dtos.BookDto;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("book-service")
public class BookController {

    private final Environment environment;

    public BookController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/{id}/{currency}")
    public BookDto getBook(@PathVariable Long id, @PathVariable String currency) {
        var port = environment.getProperty("local.server.port");
        var book = new Book(id, "Thiago Rodrigues", "Title", LocalDate.now(), 10.0, currency);
        var bookDto = new BookDto(book);
        bookDto.setEnvironment(port);
        return bookDto;
    }

}
