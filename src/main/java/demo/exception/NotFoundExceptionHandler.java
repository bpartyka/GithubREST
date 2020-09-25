package demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class NotFoundExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    public final ResponseEntity<NotFoundResponse> handleException(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new NotFoundResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
