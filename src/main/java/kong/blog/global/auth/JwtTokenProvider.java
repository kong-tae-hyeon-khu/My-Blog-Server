package kong.blog.global.auth;


import io.jsonwebtoken.Jwts;

import java.util.Date;

public class JwtTokenProvider {
    public String makeJwtToken() {
        Date now = new Date();
        return "a";
    }
}
