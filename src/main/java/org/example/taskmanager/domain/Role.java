package org.example.taskmanager.domain;


import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Role {

    private RoleName role;

    private Set<User> users;

    public Role(){ }

    public Set<User> getUsers() {
        return users;
    }

    public Role users(Set<User> users) {
        this.users = users;
        return this;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public RoleName getRole() {
        return role;
    }

    public Role role(RoleName role) {
        this.role = role;
        return this;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role=" + role +
                ", users=" + users +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return Objects.equals(role, role1.role) && Objects.equals(users, role1.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role, users);
    }
}
