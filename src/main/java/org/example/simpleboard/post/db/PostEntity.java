package org.example.simpleboard.post.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.example.simpleboard.board.db.BoardEntity;
import org.example.simpleboard.reply.db.ReplyEntity;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board;

    private String userName;

    private String password;

    private String email;

    private String status;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String title;

    private LocalDateTime postedAt;

    @OneToMany(mappedBy = "post")
    @Builder.Default
    private List<ReplyEntity> replyList = List.of();
}
