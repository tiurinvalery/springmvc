package com.valery.Site.Entities;


import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String name;

    @ManyToMany(mappedBy = "roles" ,fetch = FetchType.LAZY)
    private Set<User> users;

    public Role() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                ", name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}

