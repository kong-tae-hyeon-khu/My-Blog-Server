package kong.blog.domain.user.domain;

public enum Role {
    ROLE_USER("ROLE_USER"),
    ROLE_GUEST("ROLE_GUEST"),
    ROLE_ADMIN("ROLE_ADMIN");

    final String role;
    Role(String role) {
        this.role = role;
    }

    public String value() {
        return role;
    }
}
