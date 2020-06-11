package com.example.demo.mahout;

import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MahoutController {
    @Autowired
    private MahoutService mahoutService;

    @GetMapping("/mahout/{userId}")
    public List<RecommendedItem> recommendForUser(@PathVariable Long userId) throws TasteException {
        return mahoutService.recommend(userId);
    }
}
