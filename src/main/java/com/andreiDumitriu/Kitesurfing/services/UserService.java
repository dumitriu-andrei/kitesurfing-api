package com.andreiDumitriu.Kitesurfing.services;

import com.andreiDumitriu.Kitesurfing.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
