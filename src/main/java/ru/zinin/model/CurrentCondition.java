package ru.zinin.model;

import lombok.Data;

import java.util.Map;

@Data
public class CurrentCondition {


    private String observation_time;
    private String temp_C;
    private String temp_F;
    private String weatherCode;
    Map<String, String>[] weatherIconUrl;
    Map<String, String>[] weatherDesc;
    Map<String, String>[] lang_ru;
    private String windspeedMiles;
    private String windspeedKmph;
    private String winddirDegree;
    private String winddir16Point;
    private String precipMM;
    private String humidity;
    private String visibility;
    private Double pressure;
    private String cloudcover;
    private String FeelsLikeC;
    private String FeelsLikeF;


}

