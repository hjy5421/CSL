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

    /*
    카테고리 ID를 이용한 게시글 검색
     */
    @GetMapping("/merchandise/{category}")
    public List<Merchandise> readMerchandisesByCategory(@PathVariable long category) {
        return merchandiseRepository.findAllByCategory(category);

    }

    /*
    JSON을 이용한 게시글 등록
     */
    @PostMapping("/merchandise")
    public Merchandise createMerchandise(@RequestBody Merchandise merchandise) {
        return merchandiseRepository.save(merchandise);
    }
}
