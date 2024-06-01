package project.usersystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.usersystem.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
