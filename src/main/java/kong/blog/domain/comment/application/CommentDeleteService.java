package kong.blog.domain.comment.application;


import kong.blog.domain.comment.dao.CommentRepository;
import kong.blog.domain.comment.domain.Comment;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentDeleteService {
    private CommentRepository commentRepository;

    public CommentDeleteService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Boolean deleteComment(Long commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        if (commentOptional.isPresent()) {
            Comment comment = commentOptional.get();
            commentRepository.delete(comment);
            return true;
        } else {
            return false;
        }

    }
}
