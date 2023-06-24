package main.app.controller;

import main.app.utility.Addition;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/integers")
public class AddController {
    @PostMapping("/add")
    public String addNumbers(@RequestBody Addition addRequest) {
        int result = addRequest.getNumber1() + addRequest.getNumber2();
        return "The result is: " + result;
    }

}
