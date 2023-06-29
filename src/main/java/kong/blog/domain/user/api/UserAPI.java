package kong.blog.domain.user.api;

import kong.blog.domain.user.application.UserService;
import kong.blog.domain.user.dto.SignUp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserAPI {

    private final UserService userService;
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<SignUp.SignUpRes> signUp(@RequestBody SignUp.SignUpReq dto) {
        return new ResponseEntity<>(new SignUp.SignUpRes(userService.signUp(dto)), HttpStatus.OK);
    }
}
