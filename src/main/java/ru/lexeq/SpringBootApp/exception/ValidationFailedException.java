package ru.lexeq.SpringBootApp.exception;

public class ValidationFailedException extends Exception{
    public ValidationFailedException(String message) {super(message);}
}
