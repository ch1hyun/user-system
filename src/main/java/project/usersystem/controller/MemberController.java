package project.usersystem.controller;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.usersystem.dto.MemberDTO;
import project.usersystem.service.MemberService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/save")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return "login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        Optional<MemberDTO> findResult = memberService.login(memberDTO);

        if (findResult.isPresent()) {
            // login 성공
            MemberDTO result = findResult.get();
            session.setAttribute("loginEmail", result.getMemberEmail());
            return "main";
        } else {
            // login 실패
            return "login";
        }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<MemberDTO> findMembers = memberService.findAll();
        model.addAttribute("memberList", findMembers);

        return "list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Optional<MemberDTO> findMember = memberService.findById(id);

        if (findMember.isPresent()) {
            MemberDTO memberDTO = findMember.get();
            model.addAttribute("member", memberDTO);
        }

        return "detail";
    }
}
