package com.example.statepublicservice.exceptionHandling.exceptionHandlers;


import com.example.statepublicservice.exceptionHandling.dto.ErrorCode;
import com.example.statepublicservice.exceptionHandling.dto.RestErrorResponse;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestErrorResponse handleAlreadyExistingError(SQLIntegrityConstraintViolationException e, WebRequest request) {
        if(e.getMessage().contains("Duplicate")) {
            return RestErrorResponse.builder().errorCode(ErrorCode.USER_ALREADY_EXISTING).message("User already added").build();
        } else {
            return RestErrorResponse.builder().build();
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public RestErrorResponse handleUserNotFoundError(NoSuchElementException e, WebRequest request) {
        return RestErrorResponse.builder().errorCode(ErrorCode.USER_NOT_FOUND).message("User not found in the database").build();
    }
}
