package jp.hinagata.model.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "companies")
@Entity
public class CompanyEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "zip")
    private String zip;

    @Column(name = "address")
    private String address;

}
