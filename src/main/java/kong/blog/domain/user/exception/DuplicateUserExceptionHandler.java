package kong.blog.domain.user.exception;

import kong.blog.global.error.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DuplicateUserExceptionHandler {

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDuplicateUserException(DuplicateUserException ex) {
        return new ErrorResponse(ex.getMessage());
    }


}
