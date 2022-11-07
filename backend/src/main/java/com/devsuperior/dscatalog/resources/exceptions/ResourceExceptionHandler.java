package com.devsuperior.dscatalog.resources.exceptions;

import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class) // definindo qual a exceção que vai ser interceptada
    public ResponseEntity<StanderdError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StanderdError err = new StanderdError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value()); // .value() para que ele aceito o int
        err.setError("Resource not found"); // pega a mensagem do erro que fizemos
        err.setPath(request.getRequestURI()); // pega a rota utilizada
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class) // definindo qual a exceção que vai ser interceptada
    public ResponseEntity<StanderdError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // bad request é o padrão para quando não pode deletar.

        StanderdError err = new StanderdError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Database exception");
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
