package kong.blog.domain.user.dto;

public class DeleteUser {
    private Long userId;
    private String message;

    public DeleteUser(Long userId, String message) {
        this.userId = userId;
        this.message = message;
    }
}
