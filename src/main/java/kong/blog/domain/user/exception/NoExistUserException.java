package kong.blog.domain.user.exception;

public class NoExistUserException  extends  RuntimeException {
    public NoExistUserException(String message) {
        super(message);
    }
}
