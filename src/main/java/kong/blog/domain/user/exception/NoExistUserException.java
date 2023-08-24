package kong.blog.domain.user.exception;

public class NoExistUserException  extends  RuntimeException {
    public NoExistUserException() {
        super("해당 유저가 존재하지 않습니다.");
    }
}
