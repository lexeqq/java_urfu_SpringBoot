package ru.lexeq.SpringBootApp.service;


import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.lexeq.SpringBootApp.exception.UnsupportedCodeException;
import ru.lexeq.SpringBootApp.exception.ValidationFailedException;
import ru.lexeq.SpringBootApp.model.Request;

@Service
public class RequestValidationService  implements ValidationService {

    @Override
    public void isValid(BindingResult bindingResult, Request request)
            throws ValidationFailedException, UnsupportedCodeException {
        if ("123".equals(request.getUid())) {
            throw new UnsupportedCodeException("UID 123 не поддерживается");
        }

        if (bindingResult.hasErrors()) {
            throw new
                    ValidationFailedException(bindingResult.getFieldError().toString());
        }
    }
}
