package resume.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import resume.dto.FieldValidationErrorDto;
import resume.dto.RequestValidationErrorDto;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<RequestValidationErrorDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldValidationErrorDto> fieldValidationErrors = e.getFieldErrors().stream()
                .map(error -> new FieldValidationErrorDto(error.getField(), error.getDefaultMessage()))
                .toList();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new RequestValidationErrorDto(fieldValidationErrors));
    }
}
