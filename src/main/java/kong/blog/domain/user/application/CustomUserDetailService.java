package kong.blog.domain.user.application;

import kong.blog.domain.user.dao.UserRepository;
import kong.blog.domain.user.domain.User;
import kong.blog.domain.user.exception.NoExistUserException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws NoExistUserException {
        return userRepository.findByEmail(username)
                .orElseThrow(NoExistUserException::new);
    }

}
