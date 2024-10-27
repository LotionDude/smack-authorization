package org.smack.authorization.presentation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptions> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> messages = ex.getAllErrors().stream().map(this::getValidationMessage).toList();
        ApiExceptions apiExceptions = new ApiExceptions(HttpStatus.BAD_REQUEST, messages);

        return this.createResponseEntity(apiExceptions);
    }

    private String getValidationMessage(ObjectError error) {
        return String.format(
                "Field [%s]: %s", ((FieldError) error).getField(), error.getDefaultMessage());
    }

    private ResponseEntity<ApiExceptions> createResponseEntity(ApiExceptions exception) {
        return new ResponseEntity<>(exception, exception.getStatus());
    }
}
