package com.yang.alibabamongodb.controller;

import com.yang.alibabamongodb.domain.converter.CommentConverter;
import com.yang.alibabamongodb.domain.vo.CommentVO;
import com.yang.alibabamongodb.service.CommentService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/getComment")
    CommentVO getComment(@RequestParam String id) {
        return this.commentService.getComment(id);
    }

    @GetMapping("/add")
    CommentVO getComment(@RequestParam String userId, @RequestParam String userName, @RequestParam String content) {
        CommentVO vo = CommentVO.builder()
                .userId(userId)
                .userName(userName)
                .content(content)
                .publishTime(LocalDateTime.now())
                .build();
        return this.commentService.addComment(CommentConverter.INSTANCE.vo2po(vo));
    }

    @GetMapping("/pageByUserId")
    public Page<CommentVO> pageByUserId(@RequestParam String userId) {
        return this.commentService.pageByUserId(userId);
    }

    @GetMapping("/increase")
    public void increase(@RequestParam String docId) {
        this.commentService.increase(docId);
    }

}
