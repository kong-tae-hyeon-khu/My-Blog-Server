package kong.blog.domain.post.api;

import kong.blog.domain.post.dto.PostAdd;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PostAPI {

    @PostMapping(path = "/post", consumes = {"multipart/form-data"})
    public String uploadPost(@RequestPart(value = "dto") PostAdd.PostAddReq postAddReq, @RequestPart(value = "file", required = false)List<MultipartFile> files) {
        System.out.println(postAddReq.toString());
        System.out.println(files.toString());

        return "";
    }





}
