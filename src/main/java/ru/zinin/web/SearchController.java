package ru.zinin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.zinin.service.SearchService;

import java.util.ArrayList;
import java.util.List;

// принимает запросы на автозаполнение местоположения
@RestController
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public List search(@RequestParam String term) {

        return searchService.searchCity(term);
    }
}
