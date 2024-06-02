package project.usersystem.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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

    public Optional<MemberDTO> login(MemberDTO memberDTO) {
        /*
            1. 회원이 입력한 이메일로 DB에서 조회
            2. DB에서 조회한 비밀번호와 사용자가 입력한 비밀번호가 일치하는지 판단
         */
        Optional<Member> findMember = memberRepository.findByMemberEmail(memberDTO.getMemberEmail());
        if (findMember.isPresent()) {
            Member member = findMember.get();
            if (member.getMemberPassword().equals(memberDTO.getMemberPassword())) {
                return Optional.of(MemberDTO.toMemberDTO(member));
            } else { /* 비밀번호 실패 */ }
        } else { /* 이메일 실패 */ }

        return Optional.empty();
    }

    public List<MemberDTO> findAll() {
        return memberRepository.findAll().stream()
                .map(MemberDTO::toMemberDTO)
                .collect(Collectors.toList());
    }

    public Optional<MemberDTO> findById(Long id) {
        Optional<Member> findMember = memberRepository.findById(id);

        if (findMember.isPresent()) {
            Member member = findMember.get();
            return Optional.of(MemberDTO.toMemberDTO(member));
        }

        return Optional.empty();
    }
}
