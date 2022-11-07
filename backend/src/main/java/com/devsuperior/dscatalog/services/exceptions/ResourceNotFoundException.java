package com.devsuperior.dscatalog.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionId = 1L;

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
