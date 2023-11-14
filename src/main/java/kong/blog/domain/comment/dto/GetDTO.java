package kong.blog.domain.comment.dto;

import java.time.LocalDateTime;

public class GetDTO {
    public static class GetComments {
        private Long id;
        private String comment;
        private LocalDateTime created_at;

        public GetComments( ) {}
        public GetComments(Long id, String comment, LocalDateTime created_at) {
            this.id = id;
            this.comment = comment;
            this.created_at = created_at;
        }


    }
}
