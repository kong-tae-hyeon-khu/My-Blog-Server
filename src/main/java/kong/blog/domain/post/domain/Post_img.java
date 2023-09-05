package kong.blog.domain.post.domain;

import javax.persistence.*;

public class Post_img {
    @Id
    private Long id;

    @Column
    private String img_url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
