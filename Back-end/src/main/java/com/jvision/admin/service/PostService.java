package com.jvision.admin.service;

import com.jvision.admin.domain.posts.PostRepository;
import com.jvision.admin.domain.posts.Posts;
import com.jvision.admin.dto.PostResponseDto;
import com.jvision.admin.dto.PostSaveRequestDTO;
import com.jvision.admin.dto.PostUpdateRequestDto;
import com.jvision.admin.dto.PostsListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service// Service 클래스 지정
@RequiredArgsConstructor// final 또는 @NotNull 이 붙은 필드의 생성자를 생성 (의존성 주입)
public class PostService {

    public final PostRepository postRepository;

    @Transactional
    public List<PostsListResponseDto> findAllDesc(){
        return postRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional// 트랜잭션을 보장 하는 어노테이션 (commit 또는 rollback 수행)
    public Long save(PostSaveRequestDTO dto){
        return postRepository.save(dto.toEntity()).getId();
    }

    @Transactional// 트랜잭션을 보장 하는 어노테이션 (commit 또는 rollback 수행)
    public Long update(Long id, PostUpdateRequestDto dto){
        Posts posts = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id="+id));
        posts.update(dto.getTitle(),dto.getContent());
        return id;
    }

    @Transactional// 트랜잭션을 보장 하는 어노테이션 (commit 또는 rollback 수행)
    public PostResponseDto findById(Long id){
        Posts entity = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다 id="+id));
        return new PostResponseDto(entity);
    }

    @Transactional// 트랜잭션을 보장 하는 어노테이션 (commit 또는 rollback 수행)
    public void postDelete(Long id){
        Posts posts = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postRepository.delete(posts);
    }
}
