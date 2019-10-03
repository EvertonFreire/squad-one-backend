package dev.codenation.logs.core.exception.message.model;

import dev.codenation.logs.core.exception.message.AbstractException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AbstractCouldNotExecuteActionException extends AbstractException {

    public AbstractCouldNotExecuteActionException(String message) {
        super(message);
    }
}
