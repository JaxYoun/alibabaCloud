package com.yang.alibabamongodb.repository;

import com.yang.alibabamongodb.domain.po.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

    Page<Comment> findCommentByUserId(String userId, Pageable pageable);
}
