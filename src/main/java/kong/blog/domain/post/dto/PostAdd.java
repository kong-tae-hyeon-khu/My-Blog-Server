package kong.blog.domain.post.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;




public class PostAdd {

    public static class Request {
        private String title;
        private String content;
        private List<MultipartFile> files;

        public String getTitle() {
            return this.title;
        }
        public String getContent() {
            return this.content;
        }
        public List<MultipartFile> getFiles() {
            return this.files;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setFiles(List<MultipartFile> files) {
            this.files = files;
        }
    }

    public static class PostAddClientReq {
        private String title;
        private String content;

        public String getTitle() {
            return this.title;
        }
        public String getContent() {
            return this.content;
        }

        public void setTitle(String title) {
            this.title = title;
        }
        public void setContent(String content) {
            this.content = content;
        }
    }


    public static class PostAddServerReq {
        private String title;
        private String content;
        // Img URL 이 여러개 가 될 수도 있는데 . . . . => 따로 도메인을 빼서 처리.
        private List<String> imgUrl;

        public PostAddServerReq(String title, String content, List<String> imgUrl) {
            this.title = title;
            this.content = content;
            this.imgUrl = imgUrl;
        }


        public String getTitle() {
            return this.title;
        }
        public String getContent() {
            return this.content;
        }
        public List<String> getImgUrl() {
            return this.imgUrl;
        }
    }
}
