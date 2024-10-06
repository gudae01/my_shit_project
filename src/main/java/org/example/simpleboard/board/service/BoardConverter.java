package org.example.simpleboard.board.service;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.model.BoardDto;
import org.example.simpleboard.post.service.PostConverter;
import org.example.simpleboard.post.service.PostService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardConverter {

    private final PostConverter postConverter;

    public BoardDto toDto(BoardEntity boardEntity) {

        var postList = boardEntity.getPostList().stream()
                        .map(postConverter::toDto)
                        .collect(Collectors.toList());

        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();
    }
}
