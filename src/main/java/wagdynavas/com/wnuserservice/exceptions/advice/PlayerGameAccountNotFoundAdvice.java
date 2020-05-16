package wagdynavas.com.wnuserservice.exceptions.advice;

import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import wagdynavas.com.wnuserservice.exceptions.PlayerGameAccountNotFoundException;

@ControllerAdvice
@RequestMapping(produces = "application/vnd.error")
public class PlayerGameAccountNotFoundAdvice {

    VndErrors playerGameAccountNotFoundExceptionHandler(PlayerGameAccountNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
