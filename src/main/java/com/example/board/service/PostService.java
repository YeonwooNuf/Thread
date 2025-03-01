package com.example.board.service;

import com.example.board.model.Post;
import com.example.board.model.PostPostRequestBody;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private static final List<Post> posts = new ArrayList<>();

    static  {
        posts.add(new Post(1L, "Post 1", ZonedDateTime.now()));
        posts.add(new Post(2L, "Post 2", ZonedDateTime.now()));
        posts.add(new Post(3L, "Post 3", ZonedDateTime.now()));
    }

    // 모든 게시글 가져오기
    public List<Post> getAllPosts() {
        return posts;
    }

    // 특정 게시글 가져오기
    public Optional<Post> getPostByPostId(Long postId) {
        return posts.stream().filter(post -> postId.equals(post.getPostId())).findFirst();
    }

    // 게시글 생성
    public Post createPost(PostPostRequestBody postPostRequestBody) {
        // 존재할 경우 최대값, 없을 경우 1L
        Long newPostId = posts.stream().mapToLong(Post::getPostId).max().orElse(0L) + 1;

        // Post 방식에서 body 입력받은 후 게시글 생성
//        Post newPost = new Post(newPostId, postPostRequestBody.getBody(), ZonedDateTime.now());
        Post newPost = new Post(newPostId, postPostRequestBody.body(), ZonedDateTime.now());

        posts.add(newPost);

        return newPost;
    }

//    List<Post> posts = new ArrayList<>();
//        posts.add(new Post(1L, "Post 1",ZonedDateTime.now()));
//        posts.add(new Post(2L, "Post 2", ZonedDateTime.now()));
//        posts.add(new Post(3L, "Post 3", ZonedDateTime.now()));

}
