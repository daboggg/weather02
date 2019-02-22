package ru.zinin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Hourly {



    private Integer time;
    private String tempC;
    private String tempF;
    private String windspeedMiles;
    private String windspeedKmph;
    private String winddirDegree;
    private String winddir16Point;
    private String weatherCode;
    Map<String, String>[] weatherIconUrl;
    Map<String, String>[] weatherDesc;
    Map<String, String>[] lang_ru;
    private String precipMM;
    private String humidity;
    private String visibility;
    private Double pressure;
    private String cloudcover;
    private String HeatIndexC;
    private String HeatIndexF;
    private String DewPointC;
    private String DewPointF;
    private String WindChillC;
    private String WindChillF;
    private String WindGustMiles;
    private String WindGustKmph;

    @JsonProperty("FeelsLikeC")
    private String feelsLikeC;
    private String FeelsLikeF;
    private String chanceofrain;
    private String chanceofremdry;
    private String chanceofwindy;
    private String chanceofovercast;
    private String chanceofsunshine;
    private String chanceoffrost;
    private String chanceofhightemp;
    private String chanceoffog;
    private String chanceofsnow;
    private String chanceofthunder;

}
