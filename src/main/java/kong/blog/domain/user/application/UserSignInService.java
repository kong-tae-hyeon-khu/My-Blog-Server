package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserSignInService {
    private final UserRepository userRepository;

    public UserSignInService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
