package com.yang.alibabamysql.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yang.alibabamysql.domain.po.UserPO;
import com.yang.alibabamysql.domain.vo.UserVO;
import com.yang.alibabamysql.service.UserService;
import comg.yang.alibabacommon.entity.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/select")
    public Result<UserVO> select() {
        Long id = 1L;
        return Result.success(this.userService.select(id));
    }

    @GetMapping("/page")
    public Result<IPage<UserPO>> page() {
        return Result.success(this.userService.page());
    }

}
