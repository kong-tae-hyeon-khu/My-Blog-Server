package kong.blog.domain.comment.dao;

import kong.blog.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface CommentRepository extends JpaRepository<Comment, Long> {
}
