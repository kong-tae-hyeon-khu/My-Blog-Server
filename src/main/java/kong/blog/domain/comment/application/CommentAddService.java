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
import java.util.Optional;

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

    public void addComment(AddDTO.ReqAddDto dto) {
        User user = userRepository.findById(dto.getUserId()).get();
        Post post = postRepository.findById(dto.getPostId()).get();

        Comment comment = new Comment(dto.getBody(), user, post);
        comment.setCreatedAt(LocalDateTime.now());

        commentRepository.save(comment);
    }

    public void updateComment(AddDTO.ReqUpdateDto dto ) {
        Optional<Comment> optionalComment = commentRepository.findById(dto.commentId);

        if (optionalComment.isPresent()) {
            throw new RuntimeException("Error"); // 수정
        }

        Comment comment = optionalComment.get();
        comment.updateComment(dto.body);

        commentRepository.save(comment);

    }

}
