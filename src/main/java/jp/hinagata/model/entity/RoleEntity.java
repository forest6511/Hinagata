package jp.hinagata.model.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Table(name = "roles")
@Entity
public class RoleEntity extends BaseEntity {

    @Length(max = 45)
    @NotNull
    @Column(name = "name")
    private String name;

//    @ManyToMany(mappedBy = "roles" ,fetch = FetchType.LAZY)
//    private Set<UserEntity> users;

}
