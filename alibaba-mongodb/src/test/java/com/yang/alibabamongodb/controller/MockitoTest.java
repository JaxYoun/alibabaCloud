package com.yang.alibabamongodb.controller;

import com.yang.alibabamongodb.domain.vo.CommentVO;
import com.yang.alibabamongodb.repository.CommentRepository;
import com.yang.alibabamongodb.service.CommentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.mockito.Mockito.mock;

@SpringBootTest
public class MockitoTest {

//    @Resource
//    private CommentService commentService;

    @Mock
    private CommentService commentService;

    @Mock
    private CommentController commentController;

    @Before
    public void beforeEach() {
//        this.commentService = Mockito.mock(CommentService.class);
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockTest() {
        CommentVO vo = new CommentVO();
        vo.setContent("ddd");
        vo.setId("111");
        Mockito.when(commentService.getComment("1")).thenReturn(vo);
        System.err.println(this.commentService.getComment("1"));

        Mockito.when(this.commentController.getComment("1")).thenReturn(vo);
        Assert.assertEquals(vo.getContent(), this.commentController.getComment("1").getContent());
    }

}
