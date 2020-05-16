package wagdynavas.com.wnuserservice.exceptions.advice;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import wagdynavas.com.wnuserservice.exceptions.UserAlreadyExistsException;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error")
public class UserControllerAdvice {

    @ResponseBody
    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    VndErrors uerAlreadyExistExceptionHandle (UserAlreadyExistsException ex) {
       return new VndErrors("error", ex.getMessage());
    }
}
