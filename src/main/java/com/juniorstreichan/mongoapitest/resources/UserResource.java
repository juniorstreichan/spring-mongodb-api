package com.juniorstreichan.mongoapitest.resources;

import com.juniorstreichan.mongoapitest.domain.Post;
import com.juniorstreichan.mongoapitest.domain.User;
import com.juniorstreichan.mongoapitest.dto.UserDTO;
import com.juniorstreichan.mongoapitest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public ResponseEntity<UserDTO> findById(@PathVariable("id") String id) {
        User usr = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(usr));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
        User obj = new User(objDTO);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(obj.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO objDTO, @PathVariable("id") String id) {
        User obj = new User(objDTO);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<Collection<Post>> findPosts(@PathVariable("id") String id) {
        User usr = service.findById(id);
        return ResponseEntity.ok().body(usr.getPosts());
    }

}
