package com.jvision.admin.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Posts, Long> {

    @Query("select p from Posts p order by p.id DESC")
    List<Posts> findAllDesc();
}