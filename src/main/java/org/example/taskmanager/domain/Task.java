package org.example.taskmanager.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "finish_date")
    private LocalDateTime finishDate;

    @ManyToOne
    @JoinColumn
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User createBy;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "users_tasks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Set<User> performers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tasks_tags",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags;

    public void addPerformer(User user){
        performers.add(user);
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public void removeTag(Tag tag){
        tags.remove(tag);
    }

    public Task() {}

    public Long getId() {
        return id;
    }

    public Task id(Long id) {
        this.id = id;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        this.status = status;;
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
        if (this.performers != null){
            this.performers.forEach(i -> i.setTasks(null));
        }
        if (performers != null){
            performers.forEach(performer -> performer.addTask(this));
        }
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
        if (this.tags != null){
            this.tags.forEach(tag -> tag.addTask(null));
        }
        if (tags != null){
            tags.forEach(tag -> tag.addTask(this));
        }
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
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
        if (this == o){
            return true;
        }
        if (!(o instanceof Task)){
            return false;
        }
        return id == ((Task)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
