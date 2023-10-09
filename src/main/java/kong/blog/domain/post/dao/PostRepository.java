package kong.blog.domain.post.dao;

import kong.blog.domain.post.domain.Post;
import kong.blog.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser(User user);
}
