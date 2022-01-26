package com.yang.alibabamysql.dao.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.alibabamysql.dao.mapper.UserMapper;
import com.yang.alibabamysql.domain.po.UserPO;
import org.springframework.stereotype.Component;

@Component
public class UserRepository extends ServiceImpl<UserMapper, UserPO> {
}
