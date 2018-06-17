package com.juniorstreichan.mongoapitest.repositories;


import com.juniorstreichan.mongoapitest.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
