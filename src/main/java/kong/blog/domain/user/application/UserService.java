package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import kong.blog.domain.user.dto.SignUp;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(SignUp.SignUpReq dto) {
        LocalDateTime createdAt = LocalDateTime.now();
        User user = new User(dto.getName(), dto.getEmail(), dto.getPassword(), createdAt);
        userRepository.save(user);
        return user;
    }
}
