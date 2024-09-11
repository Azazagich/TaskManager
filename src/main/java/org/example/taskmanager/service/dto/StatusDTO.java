package org.example.taskmanager.service.dto;

import jakarta.persistence.*;
import org.example.taskmanager.domain.Task;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class StatusDTO implements Serializable {

    private Long id;

    private String name;

    private Set<Task> tasks;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StatusDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusDTO statusDTO = (StatusDTO) o;
        return Objects.equals(id, statusDTO.id) && Objects.equals(name, statusDTO.name) && Objects.equals(tasks, statusDTO.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, tasks);
    }
}
