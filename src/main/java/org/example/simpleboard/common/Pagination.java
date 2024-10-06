package org.example.simpleboard.common;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pagination {

    private Integer page;

    private Integer size;

    private Integer currentElements;

    private Integer totalPage;

    private Long totalElements;
}
