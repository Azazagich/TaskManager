package org.example.taskmanager.service.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDTO implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private RoleDTO role;

    @JsonIgnore
    private Set<TaskDTO> tasks;

    public UserDTO(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDTO getRole() {
        return role;
    }

    public void setRole(RoleDTO role) {
        this.role = role;
    }

    public Set<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role.getName() +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof UserDTO)){
            return false;
        }
        return id == ((UserDTO)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
