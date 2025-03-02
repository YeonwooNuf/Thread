package com.example.board.controller;

import com.example.board.model.Post;
import com.example.board.model.PostPatchRequestBody;
import com.example.board.model.PostPostRequestBody;
import com.example.board.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/posts") // 공통 엔드포인트 경로
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {

        var posts = postService.getAllPosts();

        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostByPostId(@PathVariable Long postId) {

        Optional<Post> matchingPost = postService.getPostByPostId(postId);

        return matchingPost
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostPostRequestBody postPostRequestBody) {
        // 직관적으로 변수명만 봐도 타입 추론 가능 -> var 타입으로 지정 (알아서 타입 추론)
        // var => Post 타입
        var post = postService.createPost(postPostRequestBody);
        return ResponseEntity.ok(post);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Post> updatePost(
            @PathVariable Long postId, PostPatchRequestBody postPatchRequestBody) {

        var post = postService.updatePost(postId, postPatchRequestBody);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }
}
