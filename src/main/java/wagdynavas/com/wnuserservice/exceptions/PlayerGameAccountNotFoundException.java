package wagdynavas.com.wnuserservice.exceptions;

public class PlayerGameAccountNotFoundException extends RuntimeException{

    public PlayerGameAccountNotFoundException(String message) {super(message);}

    public PlayerGameAccountNotFoundException(String message, Throwable reason) {super(message, reason);}
}
