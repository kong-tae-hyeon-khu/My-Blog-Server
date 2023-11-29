package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDeleteService {
    private UserRepository userRepository;


    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public void DeleteUser(Long userId) {
        // Comment & Post
        User user = userRepository.findById(userId).orElse(null);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}
