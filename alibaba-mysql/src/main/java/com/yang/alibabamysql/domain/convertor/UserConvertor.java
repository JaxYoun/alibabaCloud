package com.yang.alibabamysql.domain.convertor;

import com.yang.alibabamysql.domain.po.UserPO;
import com.yang.alibabamysql.domain.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConvertor {

    UserConvertor ME = Mappers.getMapper(UserConvertor.class);

    UserVO po2vo(UserPO po);

}
