package com.stackroute.springbootkafkadomain.service;

import com.stackroute.springbootkafkadomain.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User userData(User user) {
        return user;
    }
}
