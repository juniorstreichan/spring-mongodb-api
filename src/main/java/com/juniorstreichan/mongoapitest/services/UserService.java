package com.juniorstreichan.mongoapitest.services;

import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public Collection<User> findAll() {
        return repo.findAll();
    }

}
