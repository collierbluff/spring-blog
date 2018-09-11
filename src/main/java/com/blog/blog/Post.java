package com.blog.blog;


import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false)
    private String body;

    @Id @GeneratedValue
    private int id;

    public Post(String title, String body){

        this.title = title;
        this.body = body;
    }

    public Post(){}

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setId(int id){this.id = id;}
}
