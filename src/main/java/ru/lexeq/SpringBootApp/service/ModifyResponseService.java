package ru.lexeq.SpringBootApp.service;

import org.springframework.stereotype.Service;
import ru.lexeq.SpringBootApp.model.Response;

@Service
public interface ModifyResponseService {

    Response modify(Response response);
}
