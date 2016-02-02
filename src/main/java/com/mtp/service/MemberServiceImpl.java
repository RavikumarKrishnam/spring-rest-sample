package com.mtp.service;

import com.mtp.domain.Member;
import com.mtp.repository.MtpMemberRepository;
import com.mtp.service.exception.DuplicateMemberException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;



@Service
@Validated
public class MemberServiceImpl implements MemberService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);
    private final MtpMemberRepository repository;

    @Inject
    public MemberServiceImpl(final MtpMemberRepository repository) {
        this.repository = repository;
    }
    
    @Override
    @Transactional
	public Member save(@NotNull @Valid final Member member) {
    	LOGGER.debug("Creating {}", member);
        Member existing = repository.findOne(member.getUserName());
        if (existing != null) {
            throw new DuplicateMemberException(
                    String.format("There already exists a member with username=%s", member.getUserName()));
        }
        return repository.save(member);
	}

    @Override
    @Transactional(readOnly = true)
	public List<Member> getList() {
    	LOGGER.debug("Retrieving the list of all members");
             
        return repository.findAll();
	}

    @Override
    public Member getMember(String username) {
       Member existing = repository.findOne(username);
       return existing;
    }

}
