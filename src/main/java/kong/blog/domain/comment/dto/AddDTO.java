package kong.blog.domain.comment.dto;

public class AddDTO {
    public static class ReqDto {
        private String body;
        private Long postId;
        private Long userId = null;

        public ReqDto(String body, Long postId) {
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

}
