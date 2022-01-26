package dev.trodrigues.bookservice.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.trodrigues.bookservice.domain.Book;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {

    private Long id;
    private String author;
    private LocalDate launchDate;
    private Double price;
    private String title;
    private String currency;
    private String environment;

    public BookDto(Book book) {
        this.id = book.getId();
        this.author = book.getAuthor();
        this.launchDate = book.getLaunchDate();
        this.price = book.getPrice();
        this.title = book.getTitle();
        // this.currency = book.getCurrency();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(LocalDate launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

}
