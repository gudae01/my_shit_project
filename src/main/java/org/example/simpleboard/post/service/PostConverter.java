package org.example.simpleboard.post.service;

import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.model.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostConverter {

    public PostDto toDto(PostEntity postEntity) {
        return PostDto.builder()
                .id(postEntity.getId())
                .boardId(postEntity.getBoard().getId())
                .userName(postEntity.getUserName())
                .password(postEntity.getPassword())
                .email(postEntity.getEmail())
                .status(postEntity.getStatus())
                .content(postEntity.getContent())
                .title(postEntity.getTitle())
                .postedAt(postEntity.getPostedAt())
                .build();
    }
}
