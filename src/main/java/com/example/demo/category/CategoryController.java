package com.example.demo.category;

import com.example.demo.category.model.MajorCategory;
import com.example.demo.category.model.SubCategory;
import com.example.demo.category.model.input.InputCategory;
import com.example.demo.category.repository.MajorRepository;
import com.example.demo.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{major}")
    public List<SubCategory> readSubByMajor(@PathVariable String major){
        return categoryService.readSubByMajor(major);
    }

    @PostMapping("/category")
    public void createCategory(@RequestBody InputCategory inputCategory){
        categoryService.createCategory(inputCategory);
    }

    /*
    @PostMapping("category/sub")
    public SubCategory createSub(@RequestBody SubCategory subCategory){
        return categoryRepository.save(subCategory);
    }

     */
}
