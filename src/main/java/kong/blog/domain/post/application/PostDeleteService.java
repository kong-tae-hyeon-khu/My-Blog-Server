package kong.blog.domain.post.application;

import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.domain.Post;
import kong.blog.global.ContextService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostDeleteService {
    private PostRepository postRepository;
    private ContextService contextService;
    public PostDeleteService(PostRepository postRepository, ContextService contextService) {
        this.postRepository = postRepository;
        this.contextService = contextService;
    }

    public String deletePost(Long id) {
        Long userId = contextService.getContextId();
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            if ( post.getUser().getId().equals(userId)) {
                postRepository.deleteById(id);
                return "Delete Complete";
            }
        }
        return "Delete Failed";
    }
}
