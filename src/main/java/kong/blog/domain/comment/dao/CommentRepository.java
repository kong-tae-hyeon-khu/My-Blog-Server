package kong.blog.domain.comment.dao;

import kong.blog.domain.comment.domain.Comment;
import kong.blog.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByUser(User user);
}
