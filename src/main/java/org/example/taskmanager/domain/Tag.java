package org.example.taskmanager.domain;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Task> tasks;

    public Tag(){ }

    public Long getId() {
        return id;
    }

    public Tag id(Long id) {
        this.id = id;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Tag name(String name){
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Tag tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        if (this.tasks != null){
            tasks.forEach(task -> task.addTag(null));
        }
        if (tasks != null){
            tasks.forEach(task -> task.addTag(this));
        }
        this.tasks = tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }


    @Override
    public String toString() {
        return "Tag{" +
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
        if (!(o instanceof Tag)){
            return false;
        }
        return id == ((Tag)o).id;    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
