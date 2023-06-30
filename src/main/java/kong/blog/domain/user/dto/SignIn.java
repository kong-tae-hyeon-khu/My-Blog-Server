package kong.blog.domain.user.dto;

import kong.blog.domain.user.domain.User;

public class SignIn {
    public static class SignInReq {
        private String email;
        private String password;

        public SignInReq(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
    }

    public static class SignInRes {
        private String message;
        private String email;
        private String password;

        public SignInRes(User u, String message) {
            this.message = message;
            this.email = u.getEmail();
            this.password = u.getPassword();
        }

        public String getMessage() {
            return message;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }

    }
}
