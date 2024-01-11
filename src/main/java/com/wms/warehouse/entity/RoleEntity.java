package com.wms.warehouse.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleid")
    @Schema(hidden = true)
    private Long roleid;
    @Column(name = "rolename")
    private String rolename;
    public RoleEntity() {
    }
    public RoleEntity(Long roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Long getRoleid() {
        return roleid;
    }

    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

}
