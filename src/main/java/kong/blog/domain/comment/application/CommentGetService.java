package kong.blog.domain.comment.application;

import kong.blog.domain.comment.dao.CommentRepository;
import kong.blog.domain.comment.domain.Comment;
import kong.blog.domain.post.dao.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentGetService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentGetService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<Comment> getComment(Long postId) {
        return commentRepository.findAllByPost(postRepository.findById(postId).get());
    }

}
