package br.com.casadocodigo.seed.autor;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EmailCadastraoException.class)
    public ResponseError handleValidationExceptions(EmailCadastraoException ex) {
        Map<String, String> errors = new HashMap<>();
        var responseError = new ResponseError();
        errors.put("email", ex.getMessage());
        responseError.setTipo("negócio");
        return new ResponseError("Erro de negócio capturado", errors);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseError handleValidationExceptions(Exception ex) {
        Map<String, String> errors = new HashMap<>();
        return new ResponseError("tecnico", errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseError handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        var responseError = new ResponseError("negocio", errors);
        responseError.setDetalhes(errors);
        return responseError;
    }
}
