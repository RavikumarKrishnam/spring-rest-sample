package com.finance.service.findataprocessor.service;

import com.finance.service.findataprocessor.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getList();

}
