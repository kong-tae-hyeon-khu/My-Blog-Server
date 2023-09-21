package kong.blog.domain.post.application;

import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.dao.Post_imgRepository;
import kong.blog.domain.post.domain.Post;
import kong.blog.domain.post.domain.Post_img;
import kong.blog.domain.post.dto.PostAdd;
import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostAddService {
    private PostRepository postRepository;
    private UserRepository userRepository;
    private Post_imgRepository postImgRepository;

    public PostAddService(PostRepository postRepository, UserRepository userRepository, Post_imgRepository postImgRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postImgRepository = postImgRepository;

    }

    public boolean addPost(PostAdd.PostAddServerReq dto) {

        // 속도가 느린 이유..?
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String currentUserName = userDetails.getUsername();

            Optional<User> user = userRepository.findByEmail(currentUserName);
            List<String> imgUrls = dto.getImgUrl();

            List<Post_img> postImgs = new ArrayList<>();

            for (String url : imgUrls) {
                Post_img postImg = new Post_img(url);
                postImgs.add(postImg);
                postImgRepository.save(postImg);
            }

            Post post = new Post(dto.getTitle(), dto.getContent(), user.get() ,postImgs);
            postRepository.save(post);
            return true;
        }

        return false;




    }

}
