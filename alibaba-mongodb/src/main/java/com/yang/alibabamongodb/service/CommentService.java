package com.yang.alibabamongodb.service;

import com.yang.alibabamongodb.domain.po.Comment;
import com.yang.alibabamongodb.domain.vo.CommentVO;
import org.springframework.data.domain.Page;

public interface CommentService {

    /**
     * 获取评论
     *
     * @param id
     * @return
     */
    CommentVO getComment(String id);

    CommentVO addComment(Comment po);

    Page<CommentVO> pageByUserId(String userId);
}
