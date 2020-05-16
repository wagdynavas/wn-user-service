package wagdynavas.com.wnuserservice.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String mensagem) {
        super(mensagem);
    }

    public UserAlreadyExistsException(String mensagem, Throwable reason) {
        super(mensagem, reason);
    }
}
