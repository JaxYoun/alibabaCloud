package com.yang.alibabamongodb.domain.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Data
@Document(collection = "comment")
@CompoundIndex(def = "{'userId': 1, 'userName': -1}")
public class Comment {

    @Id
    private String id;

    @Indexed
    private String userId;

    @Field("userName")
    private String userName;

    @Field("content")
    private String content;

    @Field("publishTime")
    private LocalDateTime publishTime;

    private Long archId;

}
