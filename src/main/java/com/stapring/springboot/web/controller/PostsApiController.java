package com.stapring.springboot.web.controller;

import com.stapring.springboot.service.posts.PostsService;
import com.stapring.springboot.web.dto.post.PostsListResponseDto;
import com.stapring.springboot.web.dto.post.PostsResponseDto;
import com.stapring.springboot.web.dto.post.PostsSaveRequestDto;
import com.stapring.springboot.web.dto.post.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        System.out.println("title: " + requestDto.getTitle());
        System.out.println("title: " + requestDto.getAuthor());
        System.out.println("title: " + requestDto.getContent());
        System.out.println(requestDto);
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {

        return postsService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @GetMapping("/api/v1/posts/list")
    public List<PostsListResponseDto> findAll() {
        return postsService.findAllDesc();
    }
}
