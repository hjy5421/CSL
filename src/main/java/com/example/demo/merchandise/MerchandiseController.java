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
    대분류를 이용한 게시글 검색
     */
    @GetMapping("/merchandise/{major}")
    public List<Merchandise> readMerchandisesByMajor(@PathVariable String major) {
        return merchandiseRepository.findAllByMajor(major);
    }

    /*
    대분류와 소분류를 이용한 게시글 검색
     */
    @GetMapping("/merchandise/{major}/{sub}")
    public List<Merchandise> readMerchandisesByMajorAndSub(@PathVariable String major, @PathVariable String sub) {
        return merchandiseRepository.findAllByMajorAndSub(major, sub);
    }

    /*
    사용자를 이용한 게시글 검색
     */
    @GetMapping("/merchandise/member/{member}")
    public List<Merchandise> readMerchandiseByMember(@PathVariable String user) {
        return merchandiseRepository.findAllByUser(user);
    }

    /*
    JSON을 이용한 게시글 등록
     */
    @PostMapping("/merchandise")
    public Merchandise createMerchandise(@RequestBody Merchandise merchandise) {
        return merchandiseRepository.save(merchandise);
    }
}
