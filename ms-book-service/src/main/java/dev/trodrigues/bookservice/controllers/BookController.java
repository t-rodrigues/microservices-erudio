package dev.trodrigues.bookservice.controllers;

import dev.trodrigues.bookservice.dtos.BookDto;
import dev.trodrigues.bookservice.services.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book endpoint")
@RestController
@RequestMapping("book-service")
public class BookController {

    private final Environment environment;
    private final BookService bookService;

    public BookController(Environment environment, BookService bookService) {
        this.environment = environment;
        this.bookService = bookService;
    }

    @Operation(summary = "Find a book by id")
    @GetMapping("/{id}/{currency}")
    public BookDto getBook(@PathVariable Long id, @PathVariable String currency) {
        var bookDto = bookService.getBookById(id, currency);
        var port = environment.getProperty("local.server.port");
        bookDto.setEnvironment(port);
        return bookDto;
    }

}
