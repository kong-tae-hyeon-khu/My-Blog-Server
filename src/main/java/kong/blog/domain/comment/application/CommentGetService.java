package kong.blog.domain.comment.application;

import kong.blog.domain.comment.dao.CommentRepository;
import kong.blog.domain.comment.domain.Comment;
import kong.blog.domain.comment.dto.GetDTO;
import kong.blog.domain.post.dao.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentGetService {
    private CommentRepository commentRepository;
    private PostRepository postRepository;

    public CommentGetService(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    public List<GetDTO.GetComments> getComment(Long postId) {
        List<Comment> commentList = commentRepository.findAllByPost(postRepository.findById(postId).get());
        List<GetDTO.GetComments> dto = new ArrayList<>();

        for (Comment comment : commentList) {
            GetDTO.GetComments entity = new GetDTO.GetComments(comment.getId(), comment.getContents(), comment.getCreatedAt());
            dto.add(entity);
        }

        return dto;
    }

}
