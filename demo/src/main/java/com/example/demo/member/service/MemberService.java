package com.example.demo.member.service;

import com.example.demo.member.model.Member;
import com.example.demo.member.model.dto.MemberLoginRes;
import com.example.demo.member.model.dto.MemberSignupRes;
import com.example.demo.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    // 레포지토리 의존성 부여
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 서비스 제공
    // CRUD

    // Create
    // 멤버 생성
    public void create(MemberSignupRes memberSignupRes){
        memberRepository.save(Member.builder()
                .password(memberSignupRes.getPw())
                .id(memberSignupRes.getId())
                .email(memberSignupRes.getEmail())
                .build());
    }


    // Read
    // 멤버 조회
    // 전체 조회
//    public List<Member> memberList() {
//        // 조회시 주문목록 나오게
//        // 일단 멤버 리스트에서 멤버 하나씩 뽑아오기
//        List<Member> result = memberRepository.findAll();
//
//        // 멤버Dto 리스트 만들어서 멤버Dto에 주문목록 넣어서 반환
//
//        for (Member member: result) {
//            // 주문목록 저장할 리스트
//            List<Order>
//
//        }
//
//        return memberRepository.findAll();
//    }

    // 부분 조회
    public MemberLoginRes read(Integer id){
        Optional<Member> result = memberRepository.findById(id);


        if(result.isPresent()){
            Member member = result.get();

            return MemberLoginRes.builder()
                    .id(member.getId())
                    .email(member.getEmail())
                    .build();
        } else {

            return null;
        }
    }

    // Update
    // 수정
    public void update(MemberLoginRes memberLoginRes){
        memberRepository.save(Member.builder()
                .email(memberLoginRes.getEmail())
                .build());
    }

    // Delete
    // 삭제
    public void delete(Integer id){
        memberRepository.delete(Member.builder().id(id).build());
    }
}
