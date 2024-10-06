package org.example.simpleboard.board.db;

import jakarta.persistence.*;
import lombok.*;
import org.example.simpleboard.post.db.PostEntity;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    private String status;

    @OneToMany(mappedBy = "board")
    private List<PostEntity> postList = List.of();      // postEntity 1:N 관계


}
