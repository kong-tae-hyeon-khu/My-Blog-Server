package kong.blog.domain.post.application;

import kong.blog.domain.post.dao.PostRepository;
import kong.blog.domain.post.domain.Post;
import kong.blog.domain.post.dto.PostAdd;
import kong.blog.domain.user.dao.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
public class PostAddService {
    private PostRepository postRepository;
    private UserRepository userRepository;

    public PostAddService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public void addPost(PostAdd dto) {

        Post post = new Post();
        /*
        * dto 정보 (제목 / 내용 / 이미지 ) 저장.
        * */

        post.setCreatedAt(LocalDateTime.now());

        postRepository.save(post);

    }

}
