package hr.ht.marin.zadatak.rest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<?> handleAnyException(Exception e, WebRequest req) {
        // e.printStackTrace();
        Map<String, String> props = new HashMap<>();
        props.put("message", e.getMessage());
        props.put("status", "400");
        props.put("error", "Bad request");
        return new ResponseEntity<>(props, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> handleNotFound(Exception e, WebRequest req) {
        // e.printStackTrace();
        Map<String, String> props = new HashMap<>();
        props.put("message", e.getMessage());
        props.put("status", "404");
        props.put("error", "Not found");
        return new ResponseEntity<>(props, HttpStatus.NOT_FOUND);
    }
}