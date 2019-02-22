package ru.zinin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


// транслитеризация значений местоположения
@Service
public class TranslitService {



    // исключения по написанию
    Map<String, String> excepts = new HashMap<String, String>() {{
        put("москва","moscow");
        put("россия","russia");
    }};



    public String translation(String input_city) {

        String city = input_city.trim();

        Properties properties = null;
        try {
            properties = PropertiesLoaderUtils.loadAllProperties("except.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }

       Enumeration en =  properties.propertyNames();

        while (en.hasMoreElements()) {
            String s = (String) en.nextElement();
            if (s.contains(city)) {
                return properties.getProperty(s);
            }
        }


        if (Character.isDigit(city.charAt(0))) {
            return city;
        }
        String pattern = "^[ a-zA-Z,-]+$";
        if (city.matches(pattern)) {
            return city;
        }
        return doTranslation(city);
    }

    private String doTranslation(String input_city) {
        String city = input_city.toLowerCase();

        // исключения по написанию


//        String[] rus = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф",  "х",  "ц",  "ч",   "ш", "щ",   "ъ", "ы", "ь", "э", "ю",  "я"};
        char[] rus = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'};
        String[] lat = {"a", "b", "v", "g", "d", "e", "e", "zh", "z", "i", "i", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "kh", "ts", "ch", "sh", "shch", "", "y", "", "e", "yu", "ya"};

        StringBuilder sb = new StringBuilder();

        boolean flag = false;
        for (int i = 0; i < city.length(); i++) {
            flag = false;
            for (int j = 0; j < rus.length; j++) {
                if (city.charAt(i) == rus[j]) {
                    sb.append(lat[j]);
                    flag = true;
                }
            }
            if (flag == false) {
                sb.append(city.charAt(i));
            }
        }
        return sb.toString();
    }
}
