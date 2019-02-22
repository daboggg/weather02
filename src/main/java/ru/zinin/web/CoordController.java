package ru.zinin.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoordController {

    @GetMapping("/coord")
    public String[] coord() {
        return new String[]{"2","2"};
    }

}
