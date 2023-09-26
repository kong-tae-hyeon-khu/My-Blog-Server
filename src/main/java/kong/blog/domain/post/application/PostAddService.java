package kong.blog.domain.post.application;

import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.dao.Post_imgRepository;
import kong.blog.domain.post.domain.Post_img;
import kong.blog.domain.post.dto.Post;
import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostAddService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final Post_imgRepository postImgRepository;

    private final ImageUploadService imageUploadService;

    public PostAddService(PostRepository postRepository, UserRepository userRepository, Post_imgRepository postImgRepository, ImageUploadService imageUploadService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postImgRepository = postImgRepository;
        this.imageUploadService = imageUploadService;


    }

    public boolean addPost(Post.Request dto) {


        // 수정하기.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String currentUserName = userDetails.getUsername();
            Optional<User> user = userRepository.findById(Long.parseLong(currentUserName));

            // 수정하기.
            List<Post_img> postImgs = new ArrayList<>();

            List<String> imgUrls =  imageUploadService.imagesUpload(dto.getFiles());
            for (String url : imgUrls) {
                Post_img postImg = new Post_img(url);
                postImgs.add(postImg);
                postImgRepository.save(postImg);
            }

            kong.blog.domain.post.domain.Post post = new kong.blog.domain.post.domain.Post(dto.getTitle(), dto.getContent(), user.get() ,postImgs);
            postRepository.save(post);
            return true;
        }

        return false;




    }

}
