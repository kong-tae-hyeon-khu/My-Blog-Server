package kong.blog.domain.comment.dto;

public class AddDTO {
    public static class ReqAddDto {

        private String body;
        private Long postId;
        private Long userId = null;

        public ReqAddDto(String body, Long postId) {
            this.body = body;
            this.postId = postId;
        }

        // Setter
        public Long setUserId(Long userId) {return this.userId = userId;}

        // Getter
        public String getBody() {return this.body;}
        public Long getPostId() {return this.postId;}
        public Long getUserId() {return this.userId;}
    }
    
    public static class ReqUpdateDto {
        public Long commentId;
        public String body;

        public ReqUpdateDto(Long commentId, String body) {
            this.commentId = commentId;
            this.body = body;
        }
    }

//    public static class ResCommentDto {
//
//    }

}
