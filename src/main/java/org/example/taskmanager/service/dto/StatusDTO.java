package org.example.taskmanager.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class StatusDTO implements Serializable {

    private Long id;

    private String name;

    private Set<TaskDTO> tasks = new HashSet<>();

    public StatusDTO(){ }

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

    public Set<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskDTO> tasks) {
        this.tasks = tasks;
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
        if (this == o){
            return true;
        }
        if (!(o instanceof StatusDTO)){
            return false;
        }
        return id == ((StatusDTO)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
