package com.jvision.admin.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity// Entity 클래스로 지정 (데이터베이스와 매핑)
@Getter// Get 메소드를 자동생성
@NoArgsConstructor// 기본 생성자 생성
public class Posts {

    @Id// PK 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY)// 기본키 생성 전략을 DB에게 위임(MySQL = Auto INCREMENT)
    private Long id;

    @Column(length = 500,nullable = false)// null X 길이는 500
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;

    @Builder//Builder 패턴 적용
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //수정 메소드
    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }
}
