package com.library.author;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (
        name = "author",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_author_email",
                columnNames = "email"
        )
)

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String firstName;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(length = 100)
    private String nationality;

    @OneToMany(
            mappedBy = "author",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            orphanRemoval = false,
            fetch = FetchType.LAZY
    )
    private List<Book> books = new ArrayList<>();

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    protected Author() {}

    public Author(String firstName, String lastName, String email, String nationality) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.nationality = nationality;
    }

    public Long getId()             { return id;}
    public String getFirstName()    { return firstName;}
    public String getLastName()     { return lastName;}
    public String getEmail()        { return email;}
    public String getNationality()  { return nationality;}
    public List<Book> getBooks()    { return books;}

    public void setFirstName(String firstName)     { this.firstName = firstName;}
    public void setLastName(String lastName)       { this.lastName = lastName;}
    public void setEmail(String email)             { this.email = email;}
    public void setNationality(String nationality) { this.nationality = nationality;}
}
