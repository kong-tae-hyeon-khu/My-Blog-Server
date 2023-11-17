package kong.blog.domain.post.application;


import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.domain.Post;
import kong.blog.domain.post.dto.Get;
import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostGetService {
    private UserRepository userRepository;
    private PostRepository postRepository;

    public PostGetService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public Get.GetResDto getPost(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);

        if (postOptional.isEmpty()) {
            throw new RuntimeException("해당 아이디와 일치하는 게시글이 존재하지 않습니다.");
        }

        Post post = postOptional.get();
        return new Get.GetResDto(
                post.getUser().getId(),
                post.getTitle(),
                post.getContent(),
                post.getImgUrls(),
                post.getCreatedAt()
        );
    }
    public List<Post> getMyPost() throws RuntimeException {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication != null) {
                UserDetails userDetails = (UserDetails) authentication.getPrincipal();
                Long currentUserId = Long.parseLong(userDetails.getUsername());
                User user = userRepository.findById(currentUserId).get();
                return postRepository.findAllByUser(user);
            }
            else {
                throw new RuntimeException("Not Exist User");
            }
        }
    public Page<Post> getAllByPage(Pageable pageable) {
        return postRepository.findAll(pageable);
    }
}
