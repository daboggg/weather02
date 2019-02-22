package ru.zinin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import ru.zinin.conf.AppProperties;
import ru.zinin.model.Kata;
import ru.zinin.model.Mod;
import ru.zinin.service.ApiClient;
import ru.zinin.service.SearchService;
import ru.zinin.service.TranslitService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


@Controller
public class WeatherController {

    @Autowired
    ApiClient apiClient;

    @Autowired
    TranslitService translitService;

    @Autowired
    SearchService searchService;

    @Autowired
    AppProperties properties;


    // Принимает запрос /pogoda  с параметрами:  input_city,  input_days,  period

    @GetMapping("/pogoda")
    public String getWeather(@RequestParam(value = "input_city", defaultValue = "66.37, 57.29") String input_city,
                             @RequestParam(value = "input_days", defaultValue = "1") String input_days,
                             @RequestParam(value = "period", defaultValue = "24") String period,
                             Model model) {


        // название города транслитеризованое
        String sityName = translitService.translation(input_city);

        // модель
        Mod mod = apiClient.findWeatherByCity(sityName, input_days, period);

        if (mod.getData().getRequest() != null) {
            searchService.setSity(input_city);
        }

        model.addAttribute("mod", mod);

        return "pogoda";
    }
}

