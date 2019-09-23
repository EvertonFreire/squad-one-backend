package dev.codenation.logs.exception.handler.log;

import dev.codenation.logs.exception.handler.AbstractExceptionHandler;
import dev.codenation.logs.exception.message.log.LogCouldNotBeArchivedException;
import dev.codenation.logs.exception.message.log.LogNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class LogExceptionHandler extends AbstractExceptionHandler {

    private LogNotFoundException logNotFoundException = new LogNotFoundException();

    private LogCouldNotBeArchivedException logCouldNotBeArchivedException = new LogCouldNotBeArchivedException();

    @ExceptionHandler(LogNotFoundException.class)
    public ResponseEntity<Object> logNotFoundException(){
        return new ResponseEntity<>(logNotFoundException.getLocalizedMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LogCouldNotBeArchivedException.class)
    public ResponseEntity<Object> logCannotBeArchived(){
        return new ResponseEntity<>(logCouldNotBeArchivedException.getLocalizedMessage(),HttpStatus.UNAUTHORIZED);
    }



}
