package com.example.demo.merchandise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MerchandiseController {

    @Autowired
    private MerchandiseRepository merchandiseRepository;

    //@GetMapping("/merchandise/{id}")
    //public Merchandise readMerchandise(@PathVariable long id){
    //    return merchandiseRepository.findById(id);
    //}

    @GetMapping("/merchandise/{category}")
    public List<Merchandise> readMerchandisesByCategory(@PathVariable long category){
        return merchandiseRepository.findAllByCategory(category);

    }

    @PostMapping("/merchandise")
    public void createMerchandise(@RequestBody Merchandise merchandise){
        merchandiseRepository.save(merchandise);
    }
}
