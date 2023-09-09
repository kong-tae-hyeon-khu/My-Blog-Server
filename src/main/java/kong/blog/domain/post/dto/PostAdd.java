package kong.blog.domain.post.dto;

import java.util.List;

public class PostAdd {
    public static class PostAddReq {
        private String title;
        private String content;
        // Img URL 이 여러개 가 될 수도 있는데 . . . . => 따로 도메인을 빼서 처리.

        private List<String> imgUrl;


        public String getTitle() {return this.title;}
        public String getContent() {return this.content;}

    }
}
