package project.usersystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.usersystem.dto.MemberDTO;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
    }
}