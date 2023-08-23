package org.medspa.training.repository.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(){super();}
    public UserNotFoundException(String args){
        super(args);
    }
    public UserNotFoundException(Throwable cause){super();}
    public UserNotFoundException(String errorMsg, Throwable cause){super(errorMsg,cause);}
}
