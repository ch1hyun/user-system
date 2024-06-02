package project.usersystem.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import project.usersystem.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이메일로 회원 정보 조회 (select * from member_table where email = ?)
    Optional<Member> findByEmail(String email);
}
