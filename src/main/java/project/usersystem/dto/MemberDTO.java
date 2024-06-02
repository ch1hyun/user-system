package project.usersystem.dto;

import lombok.AllArgsConstructor;
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
    private String email;
    private String password;
    private String name;

    public static MemberDTO toMemberDTO(Member member) {
        MemberDTO memberDTO = new MemberDTO();

        memberDTO.id = member.getId();
        memberDTO.email = member.getEmail();
        memberDTO.password = member.getPassword();
        memberDTO.name = member.getName();

        return memberDTO;
    }
}
