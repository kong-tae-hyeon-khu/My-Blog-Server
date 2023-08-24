package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import kong.blog.domain.user.dto.SignIn;
import kong.blog.domain.user.dto.SignUp;
import kong.blog.domain.user.exception.NoExistUserException;
import kong.blog.security.JwtTokenProvider;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignInService {
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    public UserSignInService(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String SignIn(SignIn.SignInReq dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            User u = user.get();
            if ( u.getPassword().equals(password)) {
                return jwtTokenProvider.createToken(email, u.getRole());
            } throw new NoExistUserException();
        }



        throw new NoExistUserException();
    }
}
