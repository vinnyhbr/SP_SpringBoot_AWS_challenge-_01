package exceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException (String mensage){
        super(mensage);
    }
}
