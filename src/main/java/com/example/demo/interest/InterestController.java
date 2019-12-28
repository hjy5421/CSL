package com.example.demo.interest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterestController {

    @Autowired
    private InterestRepository interestRepository;

    /*
    사용자 PK값을 이용한 관심 검색
     */
    @GetMapping("/interest/member/{id}")
    public List<Interest> readInterestByMember(@PathVariable long id) {
        return interestRepository.findAllByMemberId(id);
    }

    /*
    게시글 PK값을 이용한 관심 검색
     */
    @GetMapping("/interest/merchandise/{id}")
    public List<Interest> readInterestByMerchandise(@PathVariable long id) {
        return interestRepository.findAllByMerchandiseId(id);
    }

    /*
    JSON을 이용한 관심 등록
     */
    @PostMapping("/interest")
    public Interest createInterest(@RequestBody Interest interest){
        return interestRepository.save(interest);
    }


}
