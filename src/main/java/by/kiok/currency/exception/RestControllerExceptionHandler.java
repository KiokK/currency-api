package by.kiok.currency.exception;

import by.kiok.currency.dto.response.ErrorResponseDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.NonTransientDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static by.kiok.currency.exception.ErrorCodes.ENTITY_NOT_FOUND_CODE;
import static by.kiok.currency.exception.ErrorCodes.ERROR_DUPLICATE_KEY_CODE;
import static by.kiok.currency.exception.ErrorCodes.ERROR_VALIDATION_CODE;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(ModelEntityNotFountException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponseDto handleValidationExceptions(ModelEntityNotFountException e) {
        return new ErrorResponseDto(e.getMessage(), ENTITY_NOT_FOUND_CODE);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleConstraintViolationException(ConstraintViolationException ex) {
        List<String> errors = ex.getConstraintViolations().stream()
                .map(e -> e.getPropertyPath() + "=" + e.getMessage()).toList();
        return new ErrorResponseDto(errors.toString(), ERROR_VALIDATION_CODE);
    }

    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleException(MethodArgumentTypeMismatchException ex) {
        return new ErrorResponseDto(ex.getMessage(), ERROR_VALIDATION_CODE);
    }

    @ExceptionHandler({NonTransientDataAccessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponseDto handleNonTransientDataAccessException(NonTransientDataAccessException ex) {
        return new ErrorResponseDto(ex.getMessage(), ERROR_DUPLICATE_KEY_CODE);
    }
}
