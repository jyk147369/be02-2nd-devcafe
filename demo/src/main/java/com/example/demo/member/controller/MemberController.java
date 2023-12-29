package com.example.demo.member.controller;

import com.example.demo.member.model.dto.MemberLoginRes;
import com.example.demo.member.model.dto.MemberSignupRes;
import com.example.demo.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {
    // Service 의존성 부여
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // C
    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    ResponseEntity create(MemberSignupRes memberSignupRes){
        memberService.create(memberSignupRes);
        return ResponseEntity.ok().body("ok");
    }

    // R
//    @RequestMapping(method = RequestMethod.GET, value = "/list")
//    ResponseEntity list(){
//        return ResponseEntity.ok().body(memberService.memberList());
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(Integer id){

        return  ResponseEntity.ok().body(memberService.read(id));
    }

    // U
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    ResponseEntity update(MemberLoginRes memberLoginRes){
        memberService.update(memberLoginRes);
        return ResponseEntity.ok().body("수정");
    }

    // D
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    ResponseEntity delete(Integer id){
        memberService.delete(id);
        return ResponseEntity.ok().body("삭제");
    }


}
