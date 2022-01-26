package com.yang.alibabamysql.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yang.alibabamysql.domain.po.UserPO;
import com.yang.alibabamysql.domain.vo.UserVO;
import com.yang.alibabamysql.service.UserService;
import comg.yang.alibabacommon.entity.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(value = "用户接口", tags = "用户接口 yjx")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("查询单个")
    @GetMapping("/one")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "主键", value = "id", required = true)
    })
    public Result<UserVO> one(@RequestParam Long id) {
        return Result.success(this.userService.select(id));
    }

    @ApiOperation("分页查询")
    @GetMapping("/page")
    public Result<IPage<UserPO>> page() {
        return Result.success(this.userService.page());
    }

}
