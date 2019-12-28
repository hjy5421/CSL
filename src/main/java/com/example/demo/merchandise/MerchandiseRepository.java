package com.example.demo.merchandise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Long> {
    Merchandise findById(long id);
    List<Merchandise> findAllByCategory(long category);
}
