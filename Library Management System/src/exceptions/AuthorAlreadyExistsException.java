package exceptions;

public class AuthorAlreadyExistsException extends RuntimeException{
    public AuthorAlreadyExistsException (String mensage){
        super(mensage);
    }

}
