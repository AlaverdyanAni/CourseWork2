package com.example.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QuestionsAlreadyExistException extends RuntimeException {
    public QuestionsAlreadyExistException() {
    }

    public QuestionsAlreadyExistException(String message) {
        super(message);
    }

    public QuestionsAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsAlreadyExistException(Throwable cause) {
        super(cause);
    }

    public QuestionsAlreadyExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
