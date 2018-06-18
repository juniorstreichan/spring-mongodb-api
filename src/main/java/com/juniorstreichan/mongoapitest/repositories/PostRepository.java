package com.juniorstreichan.mongoapitest.repositories;


import com.juniorstreichan.mongoapitest.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Collection<Post> findByTitleContainingIgnoreCaseOrderByDateDesc(String text);

}
