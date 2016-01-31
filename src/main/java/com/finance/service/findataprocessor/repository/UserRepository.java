package com.finance.service.findataprocessor.repository;

import com.finance.service.findataprocessor.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
