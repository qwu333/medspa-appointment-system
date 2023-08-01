package org.medspa.training.model;

import javax.persistence.*;
import java.util.List;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    private String name;
    @Column(name = "allowed_resource")
    private String allowedResource;
    @Column(name = "allowed_read")
    private String allowedRead;
    @Column(name = "allowed_create")
    private String allowedCreate;
    @Column(name = "allowed_update")
    private String allowedUpdate;
    @Column(name = "allowed_delete")
    private String allowedDelete;

    @ManyToMany(mappedBy = "roles")
    private List<User> user;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAllowedResource() {
        return allowedResource;
    }

    public void setAllowedResource(String allowedResource) {
        this.allowedResource = allowedResource;
    }

    public String getAllowedRead() {
        return allowedRead;
    }

    public void setAllowedRead(String allowedRead) {
        this.allowedRead = allowedRead;
    }

    public String getAllowedCreate() {
        return allowedCreate;
    }

    public void setAllowedCreate(String allowedCreate) {
        this.allowedCreate = allowedCreate;
    }

    public String getAllowedUpdate() {
        return allowedUpdate;
    }

    public void setAllowedUpdate(String allowedUpdate) {
        this.allowedUpdate = allowedUpdate;
    }

    public String getAllowedDelete() {
        return allowedDelete;
    }

    public void setAllowedDelete(String allowedDelete) {
        this.allowedDelete = allowedDelete;
    }
}
