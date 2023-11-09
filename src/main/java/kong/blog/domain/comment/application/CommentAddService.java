package kong.blog.domain.comment.application;

import kong.blog.domain.comment.dao.CommentRepository;
import kong.blog.domain.comment.domain.Comment;
import kong.blog.domain.comment.dto.AddDTO;
import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.domain.Post;
import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentAddService {
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public CommentAddService(CommentRepository commentRepository, UserRepository userRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public void addComment(AddDTO.ReqDto dto) {
        User user = userRepository.findById(dto.getUserId()).get();
        Post post = postRepository.findById(dto.getPostId()).get();

        Comment comment = new Comment(dto.getBody(), user, post);
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(comment);
    }

}
