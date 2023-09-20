package com.example.restapi.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "roles")
public class RoleEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;

    private String authority;

    public RoleEntity() {
        super();
    }

    public RoleEntity(String authority) {
        this.authority = authority;
    }

    public RoleEntity(Long roleId, String authority) {
        this.roleId = roleId;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }

    public RoleEntity setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    public Long getRoleId() {
        return roleId;
    }

    public RoleEntity setRoleId(Long roleId) {
        this.roleId = roleId;
        return this;
    }
}
