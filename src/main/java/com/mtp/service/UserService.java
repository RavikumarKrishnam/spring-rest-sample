package com.mtp.service;

import com.mtp.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> getList();

}
