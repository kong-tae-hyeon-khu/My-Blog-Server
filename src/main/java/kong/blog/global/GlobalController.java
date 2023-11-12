package kong.blog.global;


import kong.blog.security.JwtTokenProvider;
import org.springframework.web.bind.annotation.*;

@RestController
public class GlobalController {

    private JwtTokenProvider jwtTokenProvider;

    public GlobalController(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    // RequestParam vs RequestPart
    @RequestMapping(value = "/global/jwt", method = RequestMethod.GET)
    public boolean validateJWT(@RequestParam String jwt) {
        if (jwtTokenProvider.validateToken(jwt))
            return true;
        else
            return false;
    }
}
