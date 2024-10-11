package org.example.taskmanager.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "status", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks;

    public Status(){ }

    public Long getId() {
        return id;
    }

    public Status id(Long id){
        this.id = id;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Status status(String name){
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Status tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    //#
    public void setTasks(Set<Task> tasks) {
        if (this.tasks != null){
            tasks.forEach(task -> task.setStatus(null));
        }
        if (tasks != null){
            tasks.forEach(task -> task.setStatus(this));
        }
        this.tasks = tasks;
    }

    //#
    public void addTask(Task task){
        this.tasks.add(task);
        task.setStatus(this);
    }

    @Override
    public String toString() {
        return "Status{" +
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
        if (!(o instanceof Status)){
            return false;
        }
        return id == ((Status)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
