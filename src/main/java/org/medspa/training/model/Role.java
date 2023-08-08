package org.medspa.training.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
    @Column(name = "allowed_resource")
    private String allowedResource;
    @Column(name = "allowed_read")
    private Boolean allowedRead;
    @Column(name = "allowed_create")
    private Boolean allowedCreate;
    @Column(name = "allowed_update")
    private Boolean allowedUpdate;
    @Column(name = "allowed_delete")
    private Boolean allowedDelete;
    @ManyToMany(mappedBy ="roles")
    private List<User> users;


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

    public Boolean getAllowedRead() {
        return allowedRead;
    }

    public void setAllowedRead(String allowedRead) {
        this.allowedRead = Boolean.valueOf(allowedRead);
    }

    public Boolean getAllowedCreate() {
        return allowedCreate;
    }

    public void setAllowedCreate(String allowedCreate) {
        this.allowedCreate = Boolean.valueOf(allowedCreate);
    }

    public Boolean getAllowedUpdate() {
        return allowedUpdate;
    }

    public void setAllowedUpdate(String allowedUpdate) {
        this.allowedUpdate = Boolean.valueOf(allowedUpdate);
    }

    public Boolean getAllowedDelete() {
        return allowedDelete;
    }

    public void setAllowedDelete(String allowedDelete) {
        this.allowedDelete = Boolean.valueOf(allowedDelete);
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(){this.users = users;}
}
