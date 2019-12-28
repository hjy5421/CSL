package com.example.demo.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterestController {

    @Autowired
    private InterestRepository interestRepository;

    //@GetMapping("interest/{id}")
    //public Interest readInterest(@PathVariable long id){ return interestRepository.findById(id); }




}
