package kong.blog.domain.post.api;

import kong.blog.domain.post.application.ImageUploadService;
import kong.blog.domain.post.application.PostAddService;
import kong.blog.domain.post.dto.PostAdd;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PostAPI {

    private final ImageUploadService imageUploadService;
    private final PostAddService postAddService;

    public PostAPI(ImageUploadService imageUploadService, PostAddService postAddService) {
        this.imageUploadService = imageUploadService;
        this.postAddService = postAddService;
    }

    @PostMapping(path = "/post", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public boolean uploadPost(@ModelAttribute PostAdd.Request dto) {

        System.out.println(dto.getTitle());

        return true;
    }





}
