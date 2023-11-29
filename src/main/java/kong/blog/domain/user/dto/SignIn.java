package kong.blog.domain.user.dto;

import kong.blog.domain.user.domain.User;

public class SignIn {
    public static class SignInReq {
        public String email;
        public String password;
        public SignInReq() {}
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
        private Long id;
        private String name;

        public SignInRes(Long id, String name) {
            this.id = id;
            this.name = name;

        }

        public Long getId() {
            return this.id;
        }
        public String getName() {
            return this.name;
        }


    }
}
