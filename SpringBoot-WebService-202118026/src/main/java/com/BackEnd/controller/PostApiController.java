package com.BackEnd.controller;

import com.BackEnd.dto.PostResponseDto;
import com.BackEnd.dto.PostSaveRequestDTO;
import com.BackEnd.dto.PostUpdateRequestDto;
import com.BackEnd.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController// 스프링 MVC 컨트롤러 지정 (JSON 형태로 객체 데이터 반환)
@RequiredArgsConstructor// final 또는 @NotNull 이 붙은 필드의 생성자를 생성 (의존성 주입)
public class PostApiController {

    private final PostService postService;

    // 글 작성
    @PostMapping("/api/v1/posts")// Post 방식으로 데이터를 전송
                                 //@RequestBody HTTP 요청 Body를 자바 객체로 변환
    public Long save(@RequestBody PostSaveRequestDTO dto){
        return postService.save(dto);
    }

    //글 수정
    @PutMapping("/api/v1/posts/{id}")// Put 방식으로 데이터를 전송
                                     // @RequestBody HTTP 요청 Body를 자바 객체로 변환
                                     // @PathVariable URL 경로에 해당 변수를 할당
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto dto) {
        return postService.update(id,dto);
    }

    //글 조회
    @GetMapping("/api/v1/posts/{id}")// Get 방식으로 데이터를 전송
                                     // @PathVariable URL 경로에 해당 변수를 할당
    public PostResponseDto findByIds(@PathVariable Long id){
        return postService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postService.postDelete(id);
        return id;
    }
}
