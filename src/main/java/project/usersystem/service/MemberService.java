package project.usersystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.usersystem.dto.MemberDTO;
import project.usersystem.entity.Member;
import project.usersystem.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        memberRepository.save(Member.toSaveMember(memberDTO));
    }
}
