package com.example.demo.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;

    /*
    JSON을 이용한 사용자 등록
     */
    @PostMapping("/member")
    public Member createMember(@RequestBody Member member) {
        return memberRepository.save(member);
    }

    /*
    JSON을 이용한 사용자 수정
     */
    @PostMapping("/member/{id}")
    public Member updateMember(@RequestBody Member member, @PathVariable long id) {
        Member origin = memberRepository.findById(id);
        origin = member;

        return memberRepository.save(origin);
    }

    /*
    PK값을 통한 사용자 조회
     */
    @GetMapping("/member/{id}")
    public Member readMember(@PathVariable long id) {
        return memberRepository.findById(id);
    }

    /*
    Username, Password를 이용한 로그인
    - 성공시 사용자 정보 반환
    - 실패시 NULL
     */
    @PostMapping("/member/login")
    public Member loginMember(@RequestBody Member member) {
        return memberRepository.findByUsernameAndPassword(member.getUsername(), member.getPassword());
    }
}
