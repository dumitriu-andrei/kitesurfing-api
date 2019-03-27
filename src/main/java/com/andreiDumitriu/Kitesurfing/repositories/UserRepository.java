package com.andreiDumitriu.Kitesurfing.repositories;

import com.andreiDumitriu.Kitesurfing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String username);
}




