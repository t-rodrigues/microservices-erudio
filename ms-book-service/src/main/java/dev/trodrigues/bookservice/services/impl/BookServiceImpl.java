package dev.trodrigues.bookservice.services.impl;

import dev.trodrigues.bookservice.dtos.BookDto;
import dev.trodrigues.bookservice.repositories.BookRepository;
import dev.trodrigues.bookservice.services.BookService;
import dev.trodrigues.bookservice.services.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDto getBookById(Long id) {
        var book = this.bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found " + id));

        return new BookDto(book);
    }

}
