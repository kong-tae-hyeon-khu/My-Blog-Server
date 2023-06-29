package kong.blog.domain.user.api;

import kong.blog.domain.user.application.UserSignInService;
import kong.blog.domain.user.application.UserSignUpService;
import kong.blog.domain.user.dto.SignUp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserAPI {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    public UserAPI(UserSignUpService userSignUpService, UserSignInService userSignInService) {
        this.userSignUpService = userSignUpService;
        this.userSignInService = userSignInService;
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<SignUp.SignUpRes> signUp(@RequestBody SignUp.SignUpReq dto) {
        return new ResponseEntity<>(new SignUp.SignUpRes(userSignUpService.signUp(dto)), HttpStatus.OK);
    }
}
