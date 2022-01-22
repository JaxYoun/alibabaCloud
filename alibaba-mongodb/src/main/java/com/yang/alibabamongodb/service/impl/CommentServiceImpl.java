package com.yang.alibabamongodb.service.impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.UpdateResult;
import com.yang.alibabamongodb.domain.converter.CommentConverter;
import com.yang.alibabamongodb.domain.po.Comment;
import com.yang.alibabamongodb.domain.vo.CommentVO;
import com.yang.alibabamongodb.repository.CommentRepository;
import com.yang.alibabamongodb.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private MongoTemplate mongoTemplate;

    @Resource
    private CommentRepository commentRepository;

    @Override
    public CommentVO getComment(String id) {
        Optional<Comment> poOpt = this.commentRepository.findById(id);
        return CommentConverter.INSTANCE.po2vo(poOpt.orElse(null));
    }

    @Override
    public CommentVO addComment(Comment po) {
        Comment saved = this.commentRepository.save(po);
        return CommentConverter.INSTANCE.po2vo(saved);
    }

    @Override
    public Page<CommentVO> pageByUserId(String userId) {
        Page<Comment> poPage = this.commentRepository.findCommentByUserId(userId, PageRequest.of(0, 15));
        List<Comment> poList = poPage.getContent();
        PageImpl<CommentVO> voPage = new PageImpl<>(CommentConverter.INSTANCE.po2voList(poList));
        BeanUtils.copyProperties(poPage, voPage);
        return voPage;
    }

    @Override
    public void increase(String docId) {
        //1.构造条件对象
        Query query = Query.query(Criteria.where("_id").is(docId));
        //2.构造更新对象
        Update update = new Update();
        //2.1更新为指定值
        update.set("archId", 20);

        //2.2代步长的递增
//        update.inc("userId", 2);

        //2.3无步长递增操作
        update.inc("userId");
        UpdateResult result = this.mongoTemplate.updateFirst(query, update, Comment.class);
        System.err.println(JSON.toJSONString(result));
    }
}
