package ru.kogut.enterprise.models;

import ru.kogut.enterprise.enums.Roles;

import javax.persistence.*;

@Entity
@Table(name = "userRole")
public class Role extends AbstractEntity {

    @ManyToOne
    private User user;

    @Column
    @Enumerated(EnumType.STRING)
    private Roles roles = Roles.USER;

    public Role() {
    }

    public Role(User user, Roles roles) {
        this.user = user;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return roles.name();
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
