package com.example.demo.member.controller;

import com.example.demo.Util.FileUtil;
import com.example.demo.member.dto.MemberDTO;
import com.example.demo.member.entity.Member;
import com.example.demo.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController     // @Controller + @responsebody
//@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService service;

    @Autowired
    FileUtil fileUtil;

    @GetMapping("/register")
    public String register(){
        return "member/register";
    }

//  회원가입
    @ResponseBody
    @PostMapping("/register")
    public ResponseEntity<Boolean> registerPost(@RequestBody MemberDTO dto
//                                                @RequestBody MemberDTO dto,
//                                                @RequestPart("file") MultipartFile file
//                                                RedirectAttributes redirectAttributes
    ) {
        System.out.println(dto);

        boolean isSuccess = service.register(dto);

//        boolean isSuccess = false;
        if(isSuccess) {
            return new ResponseEntity<>(isSuccess, HttpStatus.CREATED);
        }else {
//            redirectAttributes.addFlashAttribute("msg", "아이디가 중복되었습니다.");
            return new ResponseEntity<>(isSuccess, HttpStatus.FAILED_DEPENDENCY);
        }
    }

    

    @GetMapping("/member/list")
    public void list(@RequestParam(name = "page", defaultValue = "0")int page, Model model){
        Page<MemberDTO> list = service.getList(page);
        model.addAttribute("list", list);
    }

//    @GetMapping("/member/read")
//    public void read(@RequestParam(name = "id") String userId, @RequestParam(name = "page", defaultValue = "0") int page, Model model) { //파라미터 추가
//        MemberDTO dto = service.read(id);
//        model.addAttribute("dto", dto);
//        model.addAttribute("page", page);
//    }
    @ResponseBody
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file,@RequestParam("userId") String userId) {

        MemberDTO memberDTO = service.read(userId);

        String url = fileUtil.fileUpload(file);
        memberDTO.setUserProfileImagePath(url);

        service.updateMember(userId, memberDTO);

        return new ResponseEntity<>(url, HttpStatus.CREATED);

    }

    @PostMapping("/findUserId")
    public String findUserId(@RequestBody Map<String, Object> requestBody) {
        String userName = (String) requestBody.get("userName");
        String userEmail = (String) requestBody.get("userEmail");
        return service.findId(userName,userEmail);
    }


    @PostMapping("/check-duplicate")
    public ResponseEntity<Boolean> checkIdDuplicate(@RequestBody String userIds){
        String userId = userIds.substring(0,userIds.length()-1);
        // isDuplicate가 true 라면 중복된것! false 일때 통과
        boolean isDuplicate = service.checkDuplicate(userId);
        System.out.println(isDuplicate);

        return new ResponseEntity<>(isDuplicate, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateUserInfo(@RequestBody MemberDTO dto){
        Member member = service.updateMember(dto.getUserId(), dto);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
    
}
