package kong.blog.domain.comment.domain;

import kong.blog.domain.model.BaseEntity;
import kong.blog.domain.post.domain.Post;
import kong.blog.domain.user.domain.User;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;


@Entity
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "contents")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "comment_by")
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_at")
    private Post post;

    // 생성자
    public Comment(String contents, User user, Post post) {
        this.contents = contents;
        this.user = user;
        this.post = post;
    }

    public Comment() {}
    // Setter
    public void setUser(User user) {this.user = user;}

    // Getter
    public String getContents() {return this.contents;}

}
