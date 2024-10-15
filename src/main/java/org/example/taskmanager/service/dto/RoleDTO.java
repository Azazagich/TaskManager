package org.example.taskmanager.service.dto;

import java.io.Serializable;

public class RoleDTO implements Serializable {

    private Long id;

    private String name;

    public RoleDTO() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof RoleDTO)){
            return false;
        }
        return id == ((RoleDTO)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
