package com.yang.alibabamongodb.controller;

import com.alibaba.fastjson.JSON;
import com.yang.alibabamongodb.domain.vo.CommentVO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import javax.annotation.Resource;

@SpringBootTest
public class CommentControllerTest {

    @Resource
    private CommentController commentController;

    @Test
    public void pageByUserIdTest() {
        Page<CommentVO> voPage = this.commentController.pageByUserId("1");
        System.err.println(JSON.toJSONString(voPage));
    }

}
