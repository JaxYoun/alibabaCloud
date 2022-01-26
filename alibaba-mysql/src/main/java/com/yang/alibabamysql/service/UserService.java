package com.yang.alibabamysql.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yang.alibabamysql.domain.po.UserPO;
import com.yang.alibabamysql.domain.vo.UserVO;

public interface UserService {

    UserVO select(Long id);

    IPage<UserPO> page();
}
