package com.example.board.model;

import java.time.ZonedDateTime;
import java.util.Objects;

//public record Post(Long postId, String body, ZonedDateTime createdDateTime) {
//
//}

public class Post {
    private Long postId;
    private String body;
    private ZonedDateTime createdDateTime;

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", body='" + body + '\'' +
                ", createdDateTime=" + createdDateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(postId, post.postId) && Objects.equals(body, post.body) && Objects.equals(createdDateTime, post.createdDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postId, body, createdDateTime);
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ZonedDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(ZonedDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public Post(Long postId, String body, ZonedDateTime createdDateTime) {
        this.postId = postId;
        this.body = body;
        this.createdDateTime = createdDateTime;
    }
}
