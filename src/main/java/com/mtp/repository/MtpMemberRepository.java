package com.mtp.repository;

import com.mtp.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MtpMemberRepository extends JpaRepository<Member, String>{

}
