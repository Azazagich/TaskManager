package org.example.taskmanager.service.dto;

import jakarta.persistence.*;
import org.example.taskmanager.domain.Role;
import org.example.taskmanager.domain.Task;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class UserDTO implements Serializable {

    private Long Id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private RoleDTO role;

    private Set<TaskDTO> created_tasks;

    private Set<TaskDTO> tasks;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public Set<TaskDTO> getCreated_tasks() {
        return created_tasks;
    }

    public void setCreated_tasks(Set<TaskDTO> created_tasks) {
        this.created_tasks = created_tasks;
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
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created_tasks=" + created_tasks +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(Id, userDTO.Id) &&
                Objects.equals(firstName, userDTO.firstName) &&
                Objects.equals(lastName, userDTO.lastName) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(role, userDTO.role) &&
                Objects.equals(created_tasks, userDTO.created_tasks) &&
                Objects.equals(tasks, userDTO.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, firstName, lastName, email, password, role, created_tasks, tasks);
    }
}
