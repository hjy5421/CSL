package com.example.demo;

import org.apache.mahout.cf.taste.common.TasteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MahoutController {

    @Autowired
    private MahoutService mahoutService;

    @GetMapping("/mahout")
    public String test() {
        try {
            mahoutService.testMahout();
        } catch (TasteException | IOException e) {
            e.printStackTrace();
        }

        return "Hello World";
    }
}
