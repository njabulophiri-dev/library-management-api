package com.library.exception;

public class AuthorHasBooksException extends RuntimeException {

    private final Long authorId;

    public AuthorHasBooksException(Long authorId) {
        super(String.format(
                "Author with id '%d' cannot be deleted because they have associated books",
                authorId
        ));
        this.authorId = authorId;
    }

    public Long getAuthorId() { return authorId; }
}
