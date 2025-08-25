package ru.lexeq.SpringBootApp.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.lexeq.SpringBootApp.exception.UnsupportedCodeException;
import ru.lexeq.SpringBootApp.exception.ValidationFailedException;
import ru.lexeq.SpringBootApp.model.Request;

@Service
public interface ValidationService {
    void isValid(BindingResult bindingResult, Request request)
            throws ValidationFailedException, UnsupportedCodeException;
}
