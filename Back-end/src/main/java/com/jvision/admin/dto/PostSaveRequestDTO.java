package com.jvision.admin.dto;

import com.jvision.admin.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter// Get 메소드를 자동생성
@NoArgsConstructor// 기본 생성자 자동 생성
public class PostSaveRequestDTO {

    private String title;
    private String content;
    private String author;

    @Builder// Builder 패턴 적용
    public PostSaveRequestDTO(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
            .title(title)
            .content(content)
            .author(author)
            .build();
    }
}
