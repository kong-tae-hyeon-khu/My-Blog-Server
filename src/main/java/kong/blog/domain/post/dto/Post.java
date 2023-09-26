package kong.blog.domain.post.dto;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;




public class Post {

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

}
