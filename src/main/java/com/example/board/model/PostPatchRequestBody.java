package com.example.board.model;

public record PostPatchRequestBody(String body) {

}

// Post를 Post 방식으로 사용하는 RequestBody
// 클래스 -> record 방식 선언. setter가 없음
//public class PostPostRequestBody {
//    private String body;
//
//    // 생성자
//    public PostPostRequestBody(String body) {
//        this.body = body;
//    }
//
//    // 기본 생성자
//    public PostPostRequestBody() {
//    }
//
//    // Getter & Setter
//    public String getBody() {
//        return body;
//    }
//
//    public void setBody(String body) {
//        this.body = body;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PostPostRequestBody that)) return false;
//        return Objects.equals(getBody(), that.getBody());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(getBody());
//    }
//}
