package com.library.author;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthorRequest {

    @NotBlank(message = "First name is required")
    @Size(max = 100, message = "First name must not exceed 100 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(max = 100, message = "Last name must not exceed 100 characters")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "A valid email address is required")
    private String email;

    @Size(max = 100, message = "Nationality must not exceed 100 characters")
    private String nationality;

    public AuthorRequest() {}

    public AuthorRequest(String firstName, String lastName,
                         String email, String nationality) {
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.email       = email;
        this.nationality = nationality;
    }

    public String getFirstName()      { return firstName; }
    public String getLastName()       { return lastName; }
    public String getEmail()          { return email; }
    public String getNationality()    { return nationality; }

    public void setFirstName(String firstName)      { this.firstName = firstName; }
    public void setLastName(String lastName)        { this.lastName = lastName; }
    public void setEmail(String email)              { this.email = email; }
    public void setNationality(String nationality)  { this.nationality = nationality; }
}
