package org.example.simpleboard.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.model.BoardRequest;
import org.example.simpleboard.board.service.BoardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("")
    public BoardEntity create(@Valid BoardRequest boardRequest) {

        return boardService.create(boardRequest);

    }
}
