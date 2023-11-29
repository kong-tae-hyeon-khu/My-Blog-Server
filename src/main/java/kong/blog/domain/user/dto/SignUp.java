package kong.blog.domain.user.dto;

import kong.blog.domain.user.domain.User;

public class SignUp {
    public static class SignUpReq {

        public String name;
        public String email;
        public String password;

        public SignUpReq() {}

        public SignUpReq(String name, String email, String password) {
            this.name = name;
            this.email = email;
            this.password = password;
        }



        public String getName() {return this.name;}
        public String getEmail() {return this.email;}
        public String getPassword() {return this.password;}
    }

    public static class SignUpRes {
        private Long id;
        private String name;
        private String email;
        private String password;
        public SignUpRes() {}
        public SignUpRes(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.password = user.getPassword();
        }
        public Long getId() {return this.id;}
        public String getName() {return this.name;}
        public String getEmail() {return this.email;}
        public String getPassword() {return this.password;}
    }

}
