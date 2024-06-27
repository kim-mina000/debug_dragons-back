package com.example.demo.member.controller;

import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController     // @Controller + @responsebody
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/member/list")
    public void list(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Page<MemberDTO> list = service.getList(page);
        model.addAttribute("list", list);
    }

    @GetMapping("/register")
    public String register() {
        return "/member/register";
    }


    @PostMapping("/register")
    public String registerPost(MemberDTO dto, RedirectAttributes redirectAttributes) {
        System.out.println(dto);

        boolean isSuccess = service.register(dto);

        if(isSuccess) {
            return "redirect:/";	//회원가입 성공시 메인화면 이동
        }else {
            redirectAttributes.addFlashAttribute("msg", "아이디가 중복되었습니다.");
            return "redirect:/register";	//중간경로빼주고
        }
    }

    @GetMapping("/member/read")	//주소 어떻게하는지 질문요망
    public void read(@RequestParam(name = "id") String id, @RequestParam(name = "page", defaultValue = "0") int page, Model model) { //파라미터 추가
        MemberDTO dto = service.read(id);
        model.addAttribute("dto", dto);
        model.addAttribute("page", page);
    }

}
