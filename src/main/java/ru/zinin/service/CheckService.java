package ru.zinin.service;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


// проверяет валидность введенного значения местоположения
@Service
public class CheckService {

    public boolean checkCityName(String cityName) {

        String name = cityName.trim();

        if (name.length() == 0) {
            return true;
        } else if (name.length() == 1) {
            return false;
        } else if (Character.isDigit(name.charAt(0)) || name.charAt(0) == '-' && Character.isDigit(name.charAt(1))) {
            return checkCoord(name);
        } else if (Character.isLetter(name.charAt(0))) {

            for (int i = 0; i < name.length(); i++) {

                if (name.charAt(i) == '-'||name.charAt(i)==' '||name.charAt(i)==',') {
                    continue;
                }
                if (!Character.isLetter(name.charAt(i)) ) {
                    return false;
                }

            }
            return true;
        }

        return false;
    }

    private boolean checkCoord(String name) {

        String pattern = "^-?\\d{1,2}\\.\\d{1,6},\\s*-?\\d{1,3}\\.\\d{1,6}$";

        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(name);
        if (m.find()) {
            String[] str = name.split(",");
            if (Double.parseDouble(str[0].trim()) < 90
                    && Double.parseDouble(str[0].trim()) > -90
                    && Double.parseDouble(str[1].trim()) < 180
                    && Double.parseDouble(str[1].trim()) > -180) {

                return true;
            }
        }
        return false;
    }
}
