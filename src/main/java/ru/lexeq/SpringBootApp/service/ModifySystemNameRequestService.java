package ru.lexeq.SpringBootApp.service;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.lexeq.SpringBootApp.model.Request;
import ru.lexeq.SpringBootApp.model.Systems;
import ru.lexeq.SpringBootApp.util.DateTimeUtil;

import java.util.Date;


@Service
public class ModifySystemNameRequestService implements ModifyRequestService {

    @Override
    public void modify(Request request) {
        // Изменяем поле SystemName
        request.setSystemName(Systems.CRM);
        // Изменяем поле Source
        request.setSource("Service 1");
        request.setSystemTime(DateTimeUtil.getCustomFormat().format(new Date()));


        HttpEntity<Request> httpEntity = new HttpEntity<>(request);

        new RestTemplate().exchange("http://localhost:8084/feedback",
                HttpMethod.POST,
                httpEntity,
                new ParameterizedTypeReference<>() {
                });
    }
}
