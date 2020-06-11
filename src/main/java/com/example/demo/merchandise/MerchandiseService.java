package com.example.demo.merchandise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MerchandiseService {
    @Autowired
    MerchandiseRepository merchandiseRepository;
    /*
    public List<Merchandise> searchName(String name){
        List<Merchandise> merchandises=merchandiseRepository.findByNameContaining(name);

    }
    */
}
