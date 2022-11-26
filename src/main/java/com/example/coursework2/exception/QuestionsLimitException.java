package com.example.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class QuestionsLimitException extends RuntimeException {
    public QuestionsLimitException() {
    }

    public QuestionsLimitException(String message) {
        super(message);
    }

    public QuestionsLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionsLimitException(Throwable cause) {
        super(cause);
    }

    public QuestionsLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
