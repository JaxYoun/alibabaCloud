package com.yang.alibabamongodb.domain.converter;

import com.yang.alibabamongodb.domain.po.Comment;
import com.yang.alibabamongodb.domain.vo.CommentVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    CommentVO po2vo(Comment po);

    List<CommentVO> po2voList(List<Comment> poList);

    Comment vo2po(CommentVO vo);

}
