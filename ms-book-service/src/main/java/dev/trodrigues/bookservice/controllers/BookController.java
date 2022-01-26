package dev.trodrigues.bookservice.controllers;

import dev.trodrigues.bookservice.dtos.BookDto;
import dev.trodrigues.bookservice.services.BookService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book-service")
public class BookController {

    private final Environment environment;
    private final BookService bookService;

    public BookController(Environment environment, BookService bookService) {
        this.environment = environment;
        this.bookService = bookService;
    }

    @GetMapping("/{id}/{currency}")
    public BookDto getBook(@PathVariable Long id, @PathVariable String currency) {
        var bookDto = bookService.getBookById(id);
        var port = environment.getProperty("local.server.port");
        bookDto.setCurrency(currency);
        bookDto.setEnvironment(port);
        return bookDto;
    }

}
