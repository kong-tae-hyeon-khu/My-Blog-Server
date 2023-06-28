package kong.blog.domain.user.domain;

import kong.blog.domain.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends BaseEntity {
    @Id
    private int id;
}
