package org.example.taskmanager.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Status {

    private StatusName status;

    private Set<Task> tasks;

    public Status(){ }

    public Set<Task> getTasks() {
        return tasks;
    }

    public Status tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public StatusName getStatus() {
        return status;
    }

    public Status status(StatusName status){
        this.status = status;
        return this;
    }

    public void setStatus(StatusName status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "status=" + status +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return Objects.equals(status, status1.status) && Objects.equals(tasks, status1.tasks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, tasks);
    }
}
