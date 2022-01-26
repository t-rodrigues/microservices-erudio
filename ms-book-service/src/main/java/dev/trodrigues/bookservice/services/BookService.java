package dev.trodrigues.bookservice.services;

import dev.trodrigues.bookservice.dtos.BookDto;

public interface BookService {

    BookDto getBookById(Long id, String currency);

}
