package project.usersystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import project.usersystem.entity.Member;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.id = member.getId();
        memberDTO.memberEmail = member.getMemberEmail();
        memberDTO.memberPassword = member.getMemberPassword();
        memberDTO.memberName = member.getMemberName();

        return memberDTO;
    }
}
