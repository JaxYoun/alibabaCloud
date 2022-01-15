package com.yang.alibabamongodb.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {

    private String id;

    private String userId;

    private String userName;

    private String content;

    private LocalDateTime publishTime;

    private String starCount;

}
