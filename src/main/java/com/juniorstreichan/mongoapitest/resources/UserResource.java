package com.juniorstreichan.mongoapitest.resources;

import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Collection<User>> findAll() {
        Collection<User> ret = service.findAll();
        return ResponseEntity.ok().body(ret);
    }


}
