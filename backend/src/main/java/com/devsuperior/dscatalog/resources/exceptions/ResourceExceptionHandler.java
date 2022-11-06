package com.devsuperior.dscatalog.resources.exceptions;

import com.devsuperior.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class) // definindo qual a exceção que vai ser interceptada
    public ResponseEntity<StanderdError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
        StanderdError err = new StanderdError();
        err.setTimestamp(Instant.now());
        err.setStatus(HttpStatus.NOT_FOUND.value()); // .value() para que ele aceito o int
        err.setError(e.getMessage()); // pega a mensagem do erro que fizemos
        err.setPath(request.getRequestURI()); // pega a rota utilizada
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
