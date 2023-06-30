package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import kong.blog.domain.user.dto.SignIn;
import kong.blog.domain.user.dto.SignUp;
import kong.blog.domain.user.exception.NoExistUserException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSignInService {
    private final UserRepository userRepository;

    public UserSignInService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User SignIn(SignIn.SignInReq dto) {
        String email = dto.getEmail();
        String password = dto.getPassword();

        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            User u = user.get();
            if ( u.getPassword().equals(password)) {
                return u;
            } throw new NoExistUserException("Please Check Password");
        }
        throw new NoExistUserException("No This User Exist");
    }
}
