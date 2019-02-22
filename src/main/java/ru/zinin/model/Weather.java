package ru.zinin.model;

import lombok.Data;

import java.util.Map;

@Data
public class Weather {


    private String date;
    Map<String, String>[] astronomy;
    private String maxtempC;
    private String maxtempF;
    private String mintempC;
    private String mintempF;
    private String totalSnow_cm;
    private String sunHour;
    private String uvIndex;
    Hourly hourly[];


}
