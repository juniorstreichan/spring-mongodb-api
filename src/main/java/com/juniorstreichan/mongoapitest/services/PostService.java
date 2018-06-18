package com.juniorstreichan.mongoapitest.services;


import com.juniorstreichan.mongoapitest.domain.Post;
import com.juniorstreichan.mongoapitest.repositories.PostRepository;
import com.juniorstreichan.mongoapitest.services.exception.ObjNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        return repo.findById(id)
                .orElseThrow(
                        () -> new ObjNotFound("Post não encontrado")
                );
    }

}
