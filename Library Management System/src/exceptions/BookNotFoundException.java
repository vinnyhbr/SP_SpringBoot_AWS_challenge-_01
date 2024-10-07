package exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException (String mensage){
        super(mensage);
    }

}
