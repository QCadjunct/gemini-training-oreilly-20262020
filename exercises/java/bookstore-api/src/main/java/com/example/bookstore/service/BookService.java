package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

/**
 * Service for managing books in the bookstore.
 */
@Service
public class BookService {

    private final Map<Long, Book> books = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public BookService() {
        // Initialize with sample data
        addBook("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565",
                new BigDecimal("14.99"), LocalDate.of(1925, 4, 10), "Fiction", 25);
        addBook("To Kill a Mockingbird", "Harper Lee", "978-0446310789",
                new BigDecimal("12.99"), LocalDate.of(1960, 7, 11), "Fiction", 18);
        addBook("1984", "George Orwell", "978-0451524935",
                new BigDecimal("11.99"), LocalDate.of(1949, 6, 8), "Dystopian", 30);
        addBook("Clean Code", "Robert C. Martin", "978-0132350884",
                new BigDecimal("39.99"), LocalDate.of(2008, 8, 1), "Technical", 15);
    }

    public Book addBook(String title, String author, String isbn,
                        BigDecimal price, LocalDate publishedDate, String genre, int stock) {
        Long id = idCounter.getAndIncrement();
        Book book = new Book(id, title, author, isbn, price, publishedDate, genre, stock);
        books.put(id, book);
        return book;
    }

    public Optional<Book> getBook(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Book> searchByTitle(String query) {
        String lowerQuery = query.toLowerCase();
        return books.values().stream()
                .filter(book -> book.getTitle().toLowerCase().contains(lowerQuery))
                .collect(Collectors.toList());
    }

    public List<Book> getByAuthor(String author) {
        String lowerAuthor = author.toLowerCase();
        return books.values().stream()
                .filter(book -> book.getAuthor().toLowerCase().contains(lowerAuthor))
                .collect(Collectors.toList());
    }

    public List<Book> getByGenre(String genre) {
        return books.values().stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public Optional<Book> updateBook(Long id, Book updates) {
        Book existing = books.get(id);
        if (existing == null) {
            return Optional.empty();
        }

        if (updates.getTitle() != null) existing.setTitle(updates.getTitle());
        if (updates.getAuthor() != null) existing.setAuthor(updates.getAuthor());
        if (updates.getIsbn() != null) existing.setIsbn(updates.getIsbn());
        if (updates.getPrice() != null) existing.setPrice(updates.getPrice());
        if (updates.getPublishedDate() != null) existing.setPublishedDate(updates.getPublishedDate());
        if (updates.getGenre() != null) existing.setGenre(updates.getGenre());
        if (updates.getStock() >= 0) existing.setStock(updates.getStock());

        return Optional.of(existing);
    }

    public boolean deleteBook(Long id) {
        return books.remove(id) != null;
    }

    public List<Book> getInStockBooks() {
        return books.values().stream()
                .filter(Book::isInStock)
                .collect(Collectors.toList());
    }
}
