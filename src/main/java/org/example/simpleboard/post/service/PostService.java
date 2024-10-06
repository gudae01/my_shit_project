package org.example.simpleboard.post.service;

import lombok.RequiredArgsConstructor;
import org.example.simpleboard.board.db.BoardRepository;
import org.example.simpleboard.common.Api;
import org.example.simpleboard.common.Pagination;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.db.PostRepository;
import org.example.simpleboard.post.model.PostRequest;
import org.example.simpleboard.post.model.PostViewRequest;
import org.example.simpleboard.reply.service.ReplyService;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BoardRepository boardRepository;


    public PostEntity create(PostRequest postRequest) {
        var boardEntity = boardRepository.findById(postRequest.getBoardId()).get();// << 임시 고정

        var entity = PostEntity.builder()
                .board(boardEntity)
                .userName(postRequest.getUserName())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .status("REGISTERED")
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .postedAt(LocalDateTime.now())
                .build();

        return postRepository.save(entity);
    }

    public PostEntity view(PostViewRequest postViewRequest) {
        return postRepository.findFirstByIdAndStatusOrderByIdDesc(postViewRequest.getPostId(),"REGISTERED")
                .map( it -> {
                    //entitiy 존재
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다 %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }
                    return it;
                }).orElseThrow(
                        () -> {
                            return new  RuntimeException("해당 게시글이 존재 하지 않습니다 : " + postViewRequest.getPostId());
                        }
                );

    }

    public Api<List<PostEntity>> all(Pageable pageable) {
        var list = postRepository.findAll(pageable);

        var pagination = Pagination.builder()
                .page(list.getNumber())
                .size(list.getSize())
                .currentElements(list.getNumberOfElements())
                .totalPage(list.getTotalPages())
                .totalElements(list.getTotalElements())
                .build()
                ;

        var response = Api.<List<PostEntity>>builder()
                .body(list.tolist())
                .pagination(pagination)
                .build()
                ;

        return response;
    }

    public void delete(PostViewRequest postViewRequest) {
        postRepository.findById(postViewRequest.getPostId())
                .map( it -> {
                    //entitiy 존재
                    if(!it.getPassword().equals(postViewRequest.getPassword())) {
                        var format = "패스워드가 맞지 않습니다 %s vs %s";
                        throw new RuntimeException(String.format(format, it.getPassword(), postViewRequest.getPassword()));
                    }

                    it.setStatus("UNREGISTERED");
                    postRepository.save(it);
                    return it;
                }).orElseThrow(
                        () -> {
                            return new  RuntimeException("해당 게시글이 존재 하지 않습니다 : " + postViewRequest.getPostId());
                        }
                );
    }
}
