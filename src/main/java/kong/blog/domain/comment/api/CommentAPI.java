package kong.blog.domain.comment.api;


import kong.blog.domain.comment.application.CommentAddService;
import kong.blog.domain.comment.dto.AddDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentAPI {

    private CommentAddService commentAddService;

    public CommentAPI(CommentAddService commentAddService) {
        this.commentAddService = commentAddService;
    }


    /**
     * Add Comment
     */
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public void addComment(Authentication authentication, @RequestBody AddDTO.ReqDto dto) {


        Long userId = Long.parseLong(((UserDetails) authentication.getPrincipal()).getUsername());
        System.out.println(userId);
        dto.setUserId(userId);
        commentAddService.addComment(dto);
    }
}
