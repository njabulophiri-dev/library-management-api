package com.library.book;


import com.library.author.Author;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "book",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_book_isbn",
                columnNames = "isbn"
        )
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, unique = true, length = 13)
    private String isbn;

    @Column(nullable = false)
    private Integer publicationYear;

    @Column(nullable = false, length = 100)
    private String genre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    protected Book() {}

    public Book(String title, String isbn, Integer publicationYear,
                String genre, Author author) {
        this.title           = title;
        this.isbn            =  isbn;
        this.publicationYear = publicationYear;
        this.genre           = genre;
        this.author          = author;
    }

    public Long getId()        { return id; }
    public String getTitle() { return title; }
    public String getIsbn() { return isbn; }
    public Integer getPublicationYear() { return publicationYear; }
    public String getGenre() { return genre; }
    public Author getAuthor() { return author; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public void setTitle(String title) { this.title = title; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublicationYear(Integer year) { this.publicationYear = year; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setAuthor(Author author) { this.author = author; }
}
