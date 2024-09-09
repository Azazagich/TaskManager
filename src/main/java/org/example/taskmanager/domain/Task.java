package org.example.taskmanager.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class Task {

    private String title;

    private String body;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private Status status;

    private User createBy;

    private Set<User> performers;

    private Set<Tag> tags;

    public Task() {}

    public String getTitle() {
        return title;
    }

    public Task title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public Task body(String body) {
        this.body = body;
        return this;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Task startDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public Task finishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public Status getStatus() {
        return status;
    }

    public Task status(Status status) {
        this.status = status;
        return this;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getCreateBy() {
        return createBy;
    }

    public Task createBy(User createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(User createBy) {
        this.createBy = createBy;
    }

    public Set<User> getPerformers() {
        return performers;
    }

    public Task performers(Set<User> performers) {
        this.performers = performers;
        return this;
    }

    public void setPerformers(Set<User> performers) {
        this.performers = performers;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Task tags(Set<Tag> tags){
        this.tags = tags;
        return this;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", status=" + status +
                ", createBy=" + createBy +
                ", performers=" + performers +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) &&
                Objects.equals(body, task.body) &&
                Objects.equals(startDate, task.startDate) &&
                Objects.equals(finishDate, task.finishDate) &&
                Objects.equals(status, task.status) &&
                Objects.equals(createBy, task.createBy) &&
                Objects.equals(performers, task.performers) &&
                Objects.equals(tags, task.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, body, startDate, finishDate, status, createBy, performers, tags);
    }


}
