package com.example.example2.controller;

import com.example.example2.domain.Member;
import com.example.example2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member saveMember(Member member){
        return memberService.saveMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers(){
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberByID(Long id){
        return memberService.getMemberById(id);
    }


}
