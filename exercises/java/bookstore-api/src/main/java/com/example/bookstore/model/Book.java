package com.example.bookstore.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Represents a book in the bookstore.
 */
public class Book {
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotBlank(message = "ISBN cannot be blank")
    private String isbn;

    @NotNull(message = "Price cannot be null")
    @Min(value = 0, message = "Price must be non-negative")
    private BigDecimal price;

    @PastOrPresent(message = "Published date cannot be in the future")
    private LocalDate publishedDate;

    @NotBlank(message = "Genre cannot be blank")
    private String genre;

    @Min(value = 0, message = "Stock must be non-negative")
    private int stock;

    public Book() {}

    public Book(Long id, String title, String author, String isbn,
                BigDecimal price, LocalDate publishedDate, String genre, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.publishedDate = publishedDate;
        this.genre = genre;
        this.stock = stock;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public LocalDate getPublishedDate() { return publishedDate; }
    public void setPublishedDate(LocalDate publishedDate) { this.publishedDate = publishedDate; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public boolean isInStock() {
        return stock > 0;
    }
}
