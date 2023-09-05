package kong.blog.domain.post.domain;

import kong.blog.domain.model.BaseEntity;
import kong.blog.domain.user.domain.User;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Post extends BaseEntity {
    @Id
    private Long id;
    @Column(name = "content") // 게시글 내용
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
