package com.juniorstreichan.mongoapitest.resources;


import com.juniorstreichan.mongoapitest.domain.Post;
import com.juniorstreichan.mongoapitest.resources.util.URL;
import com.juniorstreichan.mongoapitest.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findbyId(@PathVariable("id") String id) {
        Post pst = service.findById(id);
        return ResponseEntity.ok().body(pst);
    }

    @GetMapping(value = "/searchtitle")
    public ResponseEntity<Collection<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        Collection<Post> ret = service.findByTitle(title);
        return ResponseEntity.ok().body(ret);
    }

    @GetMapping(value = "/searchbody")
    public ResponseEntity<Collection<Post>> findByBody(@RequestParam(value = "body", defaultValue = "") String title) {
        title = URL.decodeParam(title);
        Collection<Post> ret = service.findByBoby(title);
        return ResponseEntity.ok().body(ret);
    }


}
