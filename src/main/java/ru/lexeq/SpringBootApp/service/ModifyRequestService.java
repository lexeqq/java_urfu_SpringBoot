package ru.lexeq.SpringBootApp.service;


import org.springframework.stereotype.Service;
import ru.lexeq.SpringBootApp.model.Request;

@Service
public interface ModifyRequestService {

    void modify(Request request);
}
