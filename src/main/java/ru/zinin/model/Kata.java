package ru.zinin.model;

import lombok.Data;

import java.util.Map;

@Data
public class Kata {

    Map<String, String>[] request;
    CurrentCondition current_condition[];
    Weather weather[];
}
