package com.yang.alibabamysql.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yang.alibabamysql.dao.repository.UserRepository;
import com.yang.alibabamysql.domain.convertor.UserConvertor;
import com.yang.alibabamysql.domain.po.UserPO;
import com.yang.alibabamysql.domain.vo.UserVO;
import com.yang.alibabamysql.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserVO select(Long id) {
        UserPO po = this.userRepository.getById(id);
        return UserConvertor.ME.po2vo(po);
    }

    @Override
    public IPage<UserPO> page() {
        Page<UserPO> page = new Page<>(1, 2);
        return this.userRepository.page(page);
    }
}
