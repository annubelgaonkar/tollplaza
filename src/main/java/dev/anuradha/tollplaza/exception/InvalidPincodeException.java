package dev.anuradha.tollplaza.exception;


public class InvalidPincodeException extends RuntimeException{

    public InvalidPincodeException(String message){
        super(message);
    }
}
