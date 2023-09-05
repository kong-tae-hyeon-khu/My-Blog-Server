package kong.blog.domain.post.domain;

import kong.blog.domain.model.BaseEntity;

import javax.persistence.*;

@Entity
public class Post_img extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "img_url")
    private String img;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Post_img() {};
    public Post_img(String img, Post post) {
        this.img = img;
        this.post = post;
    }

    // Getter
    public String getImg() {return this.img;}
    public Post getPost() {return this.post;}
}
