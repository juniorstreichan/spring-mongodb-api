package com.juniorstreichan.mongoapitest.resources;

import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.dto.UserDTO;
import com.juniorstreichan.mongoapitest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<Collection<UserDTO>> findAll() {
        Collection<UserDTO> ret = service.findAll().stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(ret);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User usr = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(usr));
    }
}
