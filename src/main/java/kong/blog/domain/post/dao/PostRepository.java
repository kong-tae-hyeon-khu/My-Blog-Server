package kong.blog.domain.post.dao;

import kong.blog.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
