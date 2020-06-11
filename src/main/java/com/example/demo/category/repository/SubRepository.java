package com.example.demo.category.repository;

import com.example.demo.category.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository<SubCategory,Long> {

}
