package kong.blog.domain.post.api;

import kong.blog.domain.post.application.ImageUploadService;
import kong.blog.domain.post.application.PostAddService;
import kong.blog.domain.post.application.PostDeleteService;
import kong.blog.domain.post.application.PostGetService;
import kong.blog.domain.post.dto.Get;
import kong.blog.domain.post.dto.Post;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostAPI {

    private final PostAddService postAddService;
    private final PostGetService postGetService;
    private final PostDeleteService postDeleteService;

    public PostAPI(PostAddService postAddService, PostGetService postGetService , PostDeleteService postDeleteService) {
        this.postAddService = postAddService;
        this.postGetService = postGetService;
        this.postDeleteService = postDeleteService;
    }

    // 게시글 작성
    @PostMapping(path = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public boolean uploadPost(@ModelAttribute Post.Request dto) {
        return postAddService.addPost(dto);
    }

    // 특정 하나의 게시글 조회
    @GetMapping(path = "/post/{id}")
    public Get.GetResDto getPost(@PathVariable("id") Long id) {
        return postGetService.getPost(id);
    }

    // 내 게시글들 조회 => Dto 처리.
    @GetMapping(path = "/post")
    public List<kong.blog.domain.post.domain.Post> getMyPost() {
        return postGetService.getMyPost();
    }

    // 글 조회 => 페이징 기법.
    @GetMapping(path = "/posts/{page}")
    public String getPosts(@PathVariable("page") Long page) {
        return "";
    }


    // 글 삭제
    @DeleteMapping(path = "/posts/{id}")
    public String deletePost(@PathVariable("id") Long id) {return postDeleteService.deletePost(id);}


}
