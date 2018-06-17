package com.juniorstreichan.mongoapitest.services;

import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.repositories.UserRepository;
import com.juniorstreichan.mongoapitest.services.exception.ObjNotFound;
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

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(
                        () -> new ObjNotFound("Usuário não encontrado")
                );
    }

}
