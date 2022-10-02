package br.com.fiap.abctechapi.handler;

import br.com.fiap.abctechapi.handler.exception.MaxAssistsException;
import br.com.fiap.abctechapi.handler.exception.MinimumAssistsRequiredException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(MinimumAssistsRequiredException.class)
    public ResponseEntity<ErrorMessageResponse> errorMinAssistRequired(MinimumAssistsRequiredException exception)
    {
        ErrorMessageResponse error = new ErrorMessageResponse();
        error.setMessage(exception.getMessage());
        error.setDescription(exception.getDescription());
        error.setTimestamp(new Date());
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<ErrorMessageResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MaxAssistsException.class)
    public ResponseEntity<ErrorMessageResponse> errorMaxAssistRequired(MaxAssistsException exception)
    {
        ErrorMessageResponse error = new ErrorMessageResponse();
        error.setMessage(exception.getMessage());
        error.setDescription(exception.getDescription());
        error.setTimestamp(new Date());
        error.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<ErrorMessageResponse>(error, HttpStatus.BAD_REQUEST);
    }
}
