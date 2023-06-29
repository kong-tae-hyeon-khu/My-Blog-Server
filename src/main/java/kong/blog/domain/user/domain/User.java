package kong.blog.domain.user.domain;

import kong.blog.domain.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column(unique = true)
    private String email;
    @Column
    private String password;
    @Column(name = "is_admin")
    private boolean isAdmin;

    public User() {};
    public User(String name, String email, String password, LocalDateTime createdAt) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.setCreatedAt(createdAt);
    }

    // Getter
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }

    public boolean getIsAdmin() {
        return this.isAdmin;
    }


}
