package jp.hinagata.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    @JsonIgnore
    private long version;

    @Column(name = "created_at")
    @NotNull
    @JsonIgnore
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @NotNull
    @JsonIgnore
    private Timestamp updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    public void prePersist() {
        Timestamp ts = new Timestamp((new Date()).getTime());
        this.createdAt = ts;
        this.updatedAt = ts;
    }

    @PreUpdate
    public void preUpdate() {
        Timestamp ts = new Timestamp((new Date()).getTime());
        this.updatedAt = ts;
    }

    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass().equals(obj.getClass())) {
            final BaseEntity childEntity = (BaseEntity) obj;
            if (this.getId() == null || childEntity.getId() == null) {
                return false;
            }
            if (this.getId().equals(childEntity.getId())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (getId() == null) {
            return -1;
        }
        return getId().hashCode();
    }
}
