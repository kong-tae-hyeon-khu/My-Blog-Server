package kong.blog.domain.post.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Get {
    public static class GetResDto {
        private Long userId;
        private String title;
        private String content;
        private List<String> imgs;
        private LocalDateTime created_at;

        public GetResDto(Long userId, String title, String content, List<String> imgs, LocalDateTime created_at) {
            this.userId = userId;
            this.title = title;
            this.content = content;
            this.imgs = imgs;
            this.created_at = created_at;
        }

    }
}
