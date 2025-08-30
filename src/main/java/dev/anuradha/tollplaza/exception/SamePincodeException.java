package dev.anuradha.tollplaza.exception;

public class SamePincodeException extends RuntimeException{
    public SamePincodeException(String message){
        super(message);
    }
}
