package kong.blog.domain.user.dto;

import kong.blog.domain.user.domain.User;

public class SignUp {
    public static class SignUpReq {

        private String name;
        private String email;
        private String password;

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
        private int id;
        private String name;
        private String email;
        private String password;

        public SignUpRes(User user) {
            this.id = user.getId();
            this.name = user.getName();
            this.email = user.getEmail();
            this.password = user.getPassword();
        }
        public int getId() {return this.id;}
        public String getName() {return this.name;}
        public String getEmail() {return this.email;}
        public String getPassword() {return this.password;}
    }

}
