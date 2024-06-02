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
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    public static Member toSaveMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.email = memberDTO.getEmail();
        member.password = memberDTO.getPassword();
        member.name = memberDTO.getName();

        return member;
    }

    public static Member toUpdateMember(MemberDTO memberDTO) {
        Member member = new Member();

        member.id = memberDTO.getId();
        member.email = memberDTO.getEmail();
        member.password = memberDTO.getPassword();
        member.name = memberDTO.getName();

        return member;
    }
}
