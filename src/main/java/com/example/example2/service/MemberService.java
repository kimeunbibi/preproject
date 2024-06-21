package com.example.example2.service;

import com.example.example2.domain.Member;
import com.example.example2.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberRepository repository;

    public Member saveMember(Member member){
        return repository.save(member);
    }

    public List<Member> getAllMembers() {
        return repository.findAll();
    }

    public Member getMemberById(Long id){
        return repository.findById(id).orElse(null);
    }
}
