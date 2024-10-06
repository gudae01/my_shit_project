package org.example.simpleboard.board.service;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.board.db.BoardRepository;
import org.example.simpleboard.board.model.BoardDto;
import org.example.simpleboard.board.model.BoardRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final BoardConverter boardConverter;

    public BoardDto create(BoardRequest boardRequest) {
        var entity = BoardEntity.builder()
                .boardName(boardRequest.getBoardName())
                .status("REGISTERED")
                .build();

        var saveEntity =  boardRepository.save(entity);
        return boardConverter.toDto(saveEntity);
    }

    public BoardDto view(Long id) {
        var entity = boardRepository.findById(id).get();
        return boardConverter.toDto(entity);
    }
}
