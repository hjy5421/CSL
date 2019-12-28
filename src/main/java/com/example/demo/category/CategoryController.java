package com.example.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    /*
    전체 카테고리 조회
     */
    @GetMapping("/category")
    public List<Category> readCategories() {
        return categoryRepository.findAll();
    }

    /*
    JSON을 이용한 카테고리 등록
     */
    @PostMapping("/category")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
