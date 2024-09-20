package org.example.taskmanager.service.dto;

import org.example.taskmanager.domain.Task;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class TaskDTO implements Serializable {
    private Long id;

    private String title;

    private String body;

    private LocalDateTime startDate;

    private LocalDateTime finishDate;

    private StatusDTO status;

    private UserDTO createBy;

    private Set<UserDTO> performers;

    private Set<TagDTO> tags;

    public TaskDTO(){ }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDateTime finishDate) {
        this.finishDate = finishDate;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public void setStatus(StatusDTO status) {
        this.status = status;
    }

    public UserDTO getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UserDTO createBy) {
        this.createBy = createBy;
    }

    public Set<UserDTO> getPerformers() {
        return performers;
    }

    public void setPerformers(Set<UserDTO> performers) {
        this.performers = performers;
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "TaskDTO{" +
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return Objects.equals(id, taskDTO.id) &&
                Objects.equals(title, taskDTO.title) &&
                Objects.equals(body, taskDTO.body) &&
                Objects.equals(startDate, taskDTO.startDate) &&
                Objects.equals(finishDate, taskDTO.finishDate) &&
                Objects.equals(status, taskDTO.status) &&
                Objects.equals(createBy, taskDTO.createBy) &&
                Objects.equals(performers, taskDTO.performers) &&
                Objects.equals(tags, taskDTO.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, startDate, finishDate, status, createBy, performers, tags);
    }
}
