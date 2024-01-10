package ma.fstt.Exception;

import ma.fstt.DTO.ErrorResp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class VolunteerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(VolunteerException.class)
    public ResponseEntity<ErrorResp> handleProductServiceException(VolunteerException exception) {
        return new ResponseEntity<>(new ErrorResp().builder()
                .errorMessage(exception.getMessage())
                .errorCode(exception.getErrorCode())
                .build(), HttpStatus.NOT_FOUND);
    }
}