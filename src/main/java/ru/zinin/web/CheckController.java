package ru.zinin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zinin.service.CheckService;


// принимает запросы на проверку валидности заполнения местоположения
@RestController
public class CheckController {

    @Autowired
    CheckService checkService;

    @GetMapping("/check_city")
    public boolean checkCity(@RequestParam(value = "input_city", defaultValue = "2222") String input_city) {

        return checkService.checkCityName(input_city);
    }
}
