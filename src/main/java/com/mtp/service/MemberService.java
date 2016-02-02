package com.mtp.service;

import com.mtp.domain.Member;
import java.util.List;



public interface MemberService {
	Member save(Member member);

    List<Member> getList();

    public Member getMember(String username);
}
