package com.library.author;

import java.time.LocalDateTime;

public class AuthorResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String nationality;
    private LocalDateTime createdAt;

    public AuthorResponse() {}

    public AuthorResponse(Long id, String firstName, String lastName,
                          String email, String nationality,
                          LocalDateTime createdAt) {
        this.id          = id;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.email       = email;
        this.nationality = nationality;
        this.createdAt   = createdAt;
    }

    public Long getId()                   { return id; }
    public String getFirstName()          { return firstName; }
    public String getLastName()           { return lastName; }
    public String getEmail()              { return email; }
    public String getNationality()        { return nationality; }
    public LocalDateTime getCreatedAt()   { return createdAt; }

    public void setId(Long id)                  { this.id = id; }
    public void setFirstName(String firstName)  { this.firstName = firstName; }
    public void setLastName(String lastName)    { this.lastName = lastName; }
    public void setEmail(String email)          { this.email = email; }
    public void setNationality(String n)        {this.nationality = n; }
    public void setCreatedAt(LocalDateTime t)   {this.createdAt = t; }
}
