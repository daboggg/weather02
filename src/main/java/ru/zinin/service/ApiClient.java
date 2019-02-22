package ru.zinin.service;

import com.google.common.collect.ImmutableMap;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.zinin.model.Mod;

@Component
public class ApiClient {

    @Autowired
    private RestTemplate restTemplate;

    // URL из application.properties с подстановкой {city} {days} {period}
    @Value("${application.urlTemplate}")
    private String url;


    // запрос на сайт и создает модель Mod
    public Mod findWeatherByCity(@NonNull String city, String days, String period) {
        ResponseEntity<Mod> response = restTemplate.getForEntity(url, Mod.class,
                ImmutableMap.of("city", city, "days", days,"period",period));
        return response.getBody();
    }
}























