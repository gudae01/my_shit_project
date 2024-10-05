package org.example.simpleboard.reply.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.simpleboard.reply.db.ReplyEntity;
import org.example.simpleboard.reply.model.ReplyRequest;
import org.example.simpleboard.reply.service.ReplyService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reply")
@RequiredArgsConstructor
public class ReplyApiController {

    private final ReplyService replyService;

    public ReplyEntity create(@Valid @RequestBody ReplyRequest replyRequest) {
        return replyService.create(replyRequest);
    }
}
