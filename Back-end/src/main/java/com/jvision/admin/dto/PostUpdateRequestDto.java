package com.jvision.admin.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter// Get 메소드를 자동생성
@NoArgsConstructor// 기본 생성자 자동 생성
public class PostUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
