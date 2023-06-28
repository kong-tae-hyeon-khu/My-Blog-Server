package kong.blog.domain.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @Column(name="created_at")
    private LocalDateTime createdAt;


    // Getter
    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }
    // Setter
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
