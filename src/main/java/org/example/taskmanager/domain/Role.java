package org.example.taskmanager.domain;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Role(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role id(Long id){
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        if (name == null){
            throw new IllegalArgumentException("Role name cannot be null");
        }

        name = name.toUpperCase();

        if (name.equals(RoleName.ADMIN)
                || name.equals(RoleName.ANONYMOUS)
                || name.equals(RoleName.MANAGER)
                || name.equals(RoleName.USER)){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid role name: " + name);
        }
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof Role)){
            return false;
        }
        return id == ((Role)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
