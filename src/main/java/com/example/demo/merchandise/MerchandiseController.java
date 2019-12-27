package com.example.demo.merchandise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MerchandiseController {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    @GetMapping("/merchandise/test")
    public String test(){
        return "Merchandise Controller";
    }

    @GetMapping("/merchandise/{id}")
    public Merchandise getMerchandise(@PathVariable long id){
        return merchandiseRepository.findById(id);
    }

    @PostMapping("/merchandise")
    public void createMerchandise(@RequestBody Merchandise merchandise){
        merchandiseRepository.save(merchandise);
    }
}
