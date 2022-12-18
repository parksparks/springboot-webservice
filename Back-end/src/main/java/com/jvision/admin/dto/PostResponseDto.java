package com.jvision.admin.dto;

import com.jvision.admin.domain.posts.Posts;
import lombok.Getter;

@Getter// Get 메소드를 자동생성
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
