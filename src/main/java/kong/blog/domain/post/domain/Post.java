package kong.blog.domain.post.domain;

import kong.blog.domain.model.BaseEntity;
import kong.blog.domain.user.domain.User;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content") // 게시글 내용
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "post_id")
    private List<Post_img> postImg;

    public Post() {}
    public Post(String title, String content, User user, List<Post_img> postImg) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.postImg = postImg;
    }

    // Getter
    public Long getId() {
        return id;
    }
    public String getContent() {
        return content;
    }
    public String getTitle() {
        return title;
    }
    public User getUser() {
        return user;
    }
    public List<Post_img> getPostImg() {return postImg;}

}
