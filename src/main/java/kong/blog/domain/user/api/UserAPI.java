package kong.blog.domain.user.api;

import kong.blog.domain.user.application.UserService;
import kong.blog.domain.user.dto.SignUp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {

    UserService userService;
    public UserAPI(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public SignUp.SignUpRes signUp(@RequestBody SignUp.SignUpReq dto) {
        return new SignUp.SignUpRes(userService.signUp(dto));
    }
}
