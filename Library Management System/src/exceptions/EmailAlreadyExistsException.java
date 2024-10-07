package exceptions;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException (String e){
        super(e);
    }
}
