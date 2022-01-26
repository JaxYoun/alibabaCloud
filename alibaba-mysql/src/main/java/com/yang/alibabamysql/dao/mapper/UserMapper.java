package com.yang.alibabamysql.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.alibabamysql.domain.po.UserPO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserPO> {
}
