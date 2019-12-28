package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("/member")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    @PostMapping("/member/{id}")
    public Member updateMember(@RequestBody Member member, @PathVariable long id) {
        Member origin = memberRepository.findById(id);
        origin = member;

        return memberRepository.save(origin);
    }


    @GetMapping("/member/{id}")
    public Member readMember(@PathVariable long id) {
        return memberRepository.findById(id);
    }

    @PostMapping("/member/login")
    public Member loginMember(@RequestBody LoginDTO loginDTO) {

        return memberRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
    }
}
