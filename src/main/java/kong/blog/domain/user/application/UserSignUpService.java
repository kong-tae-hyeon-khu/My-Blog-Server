package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import kong.blog.domain.user.dto.SignUp;
import kong.blog.domain.user.exception.DuplicateUserException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserSignUpService {
    private final UserRepository userRepository;

    public UserSignUpService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(SignUp.SignUpReq dto) {

        LocalDateTime createdAt = LocalDateTime.now();

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new DuplicateUserException();
        }

        User user = new User(dto.getName(), dto.getEmail(), dto.getPassword(), createdAt);
        userRepository.save(user);
        return user;
    }
}
