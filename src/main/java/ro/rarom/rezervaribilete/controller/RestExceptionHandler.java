package ro.rarom.rezervaribilete.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ro.rarom.rezervaribilete.exception.ResourceNotFoundException;

//aici tratam exceptiile
@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRuntimeException(ResourceNotFoundException exception) {
        return new ErrorResponse(exception.getMessage() +exception.getEntityId());
    }
}

record ErrorResponse (String message) {

}


