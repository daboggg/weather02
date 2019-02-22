package ru.zinin.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// поиск значений для автозаполнения местоположения
@Service
public class SearchService {

    List<String> townsList = new ArrayList<String>(){{
        add("усинск");
        add("москва");
        add("сыктывкар");
        add("минск");
        add("нижний новрогод");
        add("ильиногорск");
    }};

    public List<String> searchCity(String term) {
        Collections.sort(townsList);
        List<String> result = new ArrayList<>();

        int index = 0;
        for (String s : townsList) {
            if (s.toLowerCase().contains(term.toLowerCase())) {
                if (s.toLowerCase().startsWith(term.toLowerCase())) {
                    result.add(index++, s);
                } else {
                    result.add(s);
                }
            }
        }

        return result;
    }

    public void setSity(String sityName) {
        if (!Character.isLetter(sityName.charAt(0))) {
            return;
        }
        for (String s : townsList) {
            if (s.equals(sityName)) {
                return;
            }
        }
        townsList.add(sityName);
    }
}
