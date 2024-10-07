package exceptions;

public class PendingFineException extends  RuntimeException{
    public PendingFineException (String e){
        super(e);
    }
}
