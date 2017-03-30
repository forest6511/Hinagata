package jp.hinagata.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "users")
@Entity
public class UserEntity extends BaseEntity {

    @Length(max = 128)
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Length(max = 128)
    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @Length(max = 256)
    @NotNull
    @Column(name = "email", unique=true)
    private String email;

    @Length(max = 256)
    @NotNull
    @Column(name = "password")
    private String password;

    @Transient
    private String passwordConfirm;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private Set<RoleEntity> roleEntities = new HashSet<>();

}
