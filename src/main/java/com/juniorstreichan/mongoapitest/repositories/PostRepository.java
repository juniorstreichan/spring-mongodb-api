package com.juniorstreichan.mongoapitest.repositories;


import com.juniorstreichan.mongoapitest.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    Collection<Post> findByTitleContainingIgnoreCaseOrderByDateDesc(String text);

    @Query("{ 'body': { $regex: ?0 , $options: 'i' } }")
    Collection<Post> findBody(String text);

    @Query("{ $and: [{date:{$gte: ?1}},{date:{$lte: ?2}},{$or:[{ 'body': { $regex: ?0 , $options: 'i' } },{ 'title': { $regex: ?0 , $options: 'i' } },{ 'comments.text': { $regex: ?0 , $options: 'i' } }]}]}")
    Collection<Post> fullSerach(String text, Date minDate, Date maxDate);
}
