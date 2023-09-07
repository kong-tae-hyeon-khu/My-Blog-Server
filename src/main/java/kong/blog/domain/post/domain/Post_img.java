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



    public Post_img() {};
    public Post_img(String img) {
        this.img = img;
    }

    // Getter
    public String getImg() {return this.img;}
}
