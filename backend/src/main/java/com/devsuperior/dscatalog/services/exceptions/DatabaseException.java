package com.devsuperior.dscatalog.services.exceptions;

public class DatabaseException extends RuntimeException {
    private static final long serialVersionId = 1L;

    public DatabaseException(String msg) {
        super(msg);
    }
}
