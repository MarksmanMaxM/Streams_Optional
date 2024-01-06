package com.SetsMapsLists.skypro.SetsMapsLists.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeAreadyAddedException extends RuntimeException {
    public EmployeeAreadyAddedException() {
    }

    public EmployeeAreadyAddedException(String message) {
        super(message);
    }

    public EmployeeAreadyAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAreadyAddedException(Throwable cause) {
        super(cause);
    }

    public EmployeeAreadyAddedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
