package org.example.simpleboard.post.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;
import lombok.*;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.reply.db.ReplyEntity;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    private Long id;

    private BoardEntity boardId;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String content;

    private String title;

    private LocalDateTime postedAt;

}
