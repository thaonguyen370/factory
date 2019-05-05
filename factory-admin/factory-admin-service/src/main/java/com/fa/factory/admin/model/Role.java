package com.fa.factory.admin.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "roles")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "created_by")
    private String createdBy;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
