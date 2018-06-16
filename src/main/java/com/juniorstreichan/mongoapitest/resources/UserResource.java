package com.juniorstreichan.mongoapitest.resources;


import com.juniorstreichan.mongoapitest.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<Set<User>> findAll() {
        Set<User> ret = new HashSet<>();

        ret.add(new User("123", "Maria neta", "maria@neta.com"));
        ret.add(new User("999", "Maria vó", "maria@vo.com"));

        return ResponseEntity.ok().body(ret);
    }


}
