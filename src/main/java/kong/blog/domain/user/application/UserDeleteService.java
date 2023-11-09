package kong.blog.domain.user.application;

import kong.blog.domain.comment.dao.CommentRepository;
import kong.blog.domain.comment.domain.Comment;
import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.domain.Post;
import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDeleteService {
    private UserRepository userRepository;
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public UserDeleteService(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    public void DeleteUser(Long userId) {
        // Comment & Post
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            List<Post> posts = postRepository.findAllByUser(user);
            List<Comment>  comments = commentRepository.findAllByUser(user);

            for (Post p : posts) {
                p.setUser(null);
            }
            for (Comment c : comments) {
                c.setUser(null);
            }

            postRepository.saveAll(posts);
            commentRepository.saveAll(comments);

            userRepository.delete(user);
        }
    }
}
