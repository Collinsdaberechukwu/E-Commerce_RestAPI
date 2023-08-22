package com.mocos.mocos.exception;

public class AuthenticationFailedException extends IllegalArgumentException{
     public AuthenticationFailedException(String msg){
         super(msg);
     }
}
