package com.example.demo.category.service;

import com.example.demo.category.model.MajorCategory;
import com.example.demo.category.model.SubCategory;
import com.example.demo.category.model.input.InputCategory;
import com.example.demo.category.repository.MajorRepository;
import com.example.demo.category.repository.SubRepository;
import jdk.internal.loader.AbstractClassLoaderValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    MajorRepository majorRepository;

    @Autowired
    SubRepository subRepository;

    public void createCategory(InputCategory inputCategory){
        MajorCategory majorCategory=new MajorCategory();
        majorCategory.setMajor(inputCategory.getMajor());

        SubCategory subCategory=new SubCategory();
        subCategory.setSub(inputCategory.getSub());
        subCategory.setMajor(majorCategory);
        subRepository.save(subCategory);

        //majorCategory.addSubs(subCategory);
        majorRepository.save(majorCategory);
    }

    public List<SubCategory> readSubByMajor(String major){
        return majorRepository.findAllByMajor(major);
    }
}
