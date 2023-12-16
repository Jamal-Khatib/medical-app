package com.example.medicalapp.dtos;


public class PostRequestDto {

    private String title ;

    private String body;

    private Long userId ;

    private String Type ;

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
