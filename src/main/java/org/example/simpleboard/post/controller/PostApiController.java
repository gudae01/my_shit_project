package org.example.simpleboard.post.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.post.db.PostEntity;
import org.example.simpleboard.post.db.PostRepository;
import org.example.simpleboard.post.model.PostRequest;
import org.example.simpleboard.post.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    public PostEntity create(@Valid PostRequest postRequest) {

    }
}
