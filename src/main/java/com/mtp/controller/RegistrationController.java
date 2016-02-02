package com.mtp.controller;

import com.mtp.domain.Member;
import com.mtp.service.MemberService;
import com.mtp.service.exception.DuplicateMemberException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class RegistrationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);
    private final MemberService memberService;

    @Inject
    public RegistrationController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public Member createUser(@RequestBody @Valid final Member member) {
        LOGGER.debug("Received request to create the {}", member);
        return memberService.save(member);
    }

    @RequestMapping(value = "/memberlist", method = RequestMethod.GET)
    public List<Member> listUsers() {
        LOGGER.debug("Received request to list all members");       
        return memberService.getList();
    }
    @RequestMapping(value = "/member", method = RequestMethod.GET)
    public Member getUser(HttpServletRequest request) {
        LOGGER.debug("Received request to get member with given username");
        System.out.println("input param"+request.getParameter("userName"));
        
        return memberService.getMember(request.getParameter("userName"));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleUserAlreadyExistsException(DuplicateMemberException e) {
        return e.getMessage();
    }

}
