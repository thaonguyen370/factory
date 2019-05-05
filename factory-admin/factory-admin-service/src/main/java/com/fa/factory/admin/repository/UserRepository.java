package com.fa.factory.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.fa.factory.admin.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserName(String userName);

    User findByEmail(String email);

    User findBySso(String sso);
}
