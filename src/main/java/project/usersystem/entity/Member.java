package project.usersystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import project.usersystem.dto.MemberDTO;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    public static Member toSaveMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.memberEmail = memberDTO.getMemberEmail();
        member.memberPassword = memberDTO.getMemberPassword();
        member.memberName = memberDTO.getMemberName();

        return member;
    }

    public static Member toUpdateMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.id = memberDTO.getId();
        member.memberEmail = memberDTO.getMemberEmail();
        member.memberPassword = memberDTO.getMemberPassword();
        member.memberName = memberDTO.getMemberName();

        return member;
    }
}
