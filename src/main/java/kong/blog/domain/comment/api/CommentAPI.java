package kong.blog.domain.comment.api;


import kong.blog.domain.comment.application.CommentAddService;
import kong.blog.domain.comment.application.CommentDeleteService;
import kong.blog.domain.comment.application.CommentGetService;
import kong.blog.domain.comment.domain.Comment;
import kong.blog.domain.comment.dto.AddDTO;
import kong.blog.domain.comment.dto.GetDTO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentAPI {

    private CommentAddService commentAddService;
    private CommentGetService commentGetService;
    private CommentDeleteService commentDeleteService;

    public CommentAPI(CommentAddService commentAddService, CommentGetService commentGetService, CommentDeleteService commentDeleteService) {
        this.commentAddService = commentAddService;
        this.commentGetService = commentGetService;
        this.commentDeleteService = commentDeleteService;
    }


    /**
     * Add Comment
     */
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public AddDTO.ResCommentDto addComment(Authentication authentication, @RequestBody AddDTO.ReqAddDto dto) {


        Long userId = Long.parseLong(((UserDetails) authentication.getPrincipal()).getUsername());
        dto.setUserId(userId);

        Comment comment = commentAddService.addComment(dto);

        return new AddDTO.ResCommentDto("Success" ,comment);


    }

    /**
     * Update Comment
     */
    @RequestMapping(value = "/comment", method = RequestMethod.PATCH)
    public AddDTO.ResCommentDto updateComment(Authentication authentication, @RequestBody AddDTO.ReqUpdateDto dto) {
        Comment comment = commentAddService.updateComment(dto);
        return new AddDTO.ResCommentDto("Success", comment);

    }


    /**
     * Read Comment (게시글 하나에 달린!) : 상세 정보 모두.
     * */
    @RequestMapping(value = "/comment/{postId}", method = RequestMethod.GET)
    public List<GetDTO.GetComments> getComment(@PathVariable Long postId) {
        return commentGetService.getComment(postId);

    }

    /**
     * Delete Comment
     */
    @RequestMapping(value = "/comment/{commentId}", method = RequestMethod.DELETE)
    public boolean deleteComment(@PathVariable Long commentId) {
        return commentDeleteService.deleteComment(commentId);
    }
}
