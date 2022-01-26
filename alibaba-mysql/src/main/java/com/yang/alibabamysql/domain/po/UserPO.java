package com.yang.alibabamysql.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_user")
public class UserPO extends BaseModel {

    private String name;

}
