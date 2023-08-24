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
        private String token;
        private String message;

        public SignInRes(String token, String message) {
            this.token = token;
            this.message = message;

        }

        public String getMessage() {
            return this.message;
        }
        public String getToken() {
            return this.token;
        }


    }
}
