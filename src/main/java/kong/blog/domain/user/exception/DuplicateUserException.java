package kong.blog.domain.user.exception;

public class DuplicateUserException extends RuntimeException {
    public DuplicateUserException() {
        super("해당 유저가 이미 존재합니다.");
    }
}
