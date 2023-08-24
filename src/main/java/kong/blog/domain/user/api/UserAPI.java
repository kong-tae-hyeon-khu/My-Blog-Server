package kong.blog.domain.user.api;

import kong.blog.domain.user.application.UserSignInService;
import kong.blog.domain.user.application.UserSignUpService;
import kong.blog.domain.user.dto.SignIn;
import kong.blog.domain.user.dto.SignUp;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserAPI {

    private final UserSignUpService userSignUpService;
    private final UserSignInService userSignInService;
    public UserAPI(UserSignUpService userSignUpService, UserSignInService userSignInService) {
        this.userSignUpService = userSignUpService;
        this.userSignInService = userSignInService;
    }

    @RequestMapping(value = "/user/signup", method = RequestMethod.POST)
    public ResponseEntity<SignUp.SignUpRes> signUp(@RequestBody SignUp.SignUpReq dto) {
        return new ResponseEntity<>(new SignUp.SignUpRes(userSignUpService.signUp(dto)), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/signin", method = RequestMethod.POST)
    public ResponseEntity<SignIn.SignInRes> signIn(@RequestBody SignIn.SignInReq dto) {
        return new ResponseEntity<>(new SignIn.SignInRes(userSignInService.SignIn(dto),"Login Success"), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    public String test() {
        return "작동.";
    }
}
