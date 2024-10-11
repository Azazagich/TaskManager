package org.example.taskmanager.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @ManyToOne
    @JoinColumn
    private Role role;

//    @PreRemove
//    private void removeTaskAssociations() {
//        for (Task task : this.tasks) {
//            task.getPerformers().remove(this);
//        }
//    }

    @ManyToMany(mappedBy = "performers", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Task> tasks;


    public void addTask(Task task){
        this.tasks.add(task);
    }



    public User(){ }

    public Long getId() {
        return id;
    }

    public User id(Long id){
        this.id = id;
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public Set<Task> getCreated_tasks() {
//        return created_tasks;
//    }
//
//    public User created_tasks(Set<Task> created_tasks) {
//        this.created_tasks = created_tasks;
//        return this;
//    }
//
//    public void setCreated_tasks(Set<Task> created_tasks) {
//        this.created_tasks = created_tasks;
//    }

    public String getEmail() {
        return email;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public User role(Role role){
        this.role = role;
        return this;
    }

    public void setRole(Role role) {
        this.role = role;
        role.addUser(this);
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public User tasks(Set<Task> tasks) {
        this.tasks = tasks;
        return this;
    }

    public void setTasks(Set<Task> tasks) {
        if (this.tasks != null){
            tasks.forEach(task -> task.setPerformers(null));
        }
        if (tasks != null){
            tasks.forEach(task -> task.addPerformer(this));
        }
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role.getName() +
                /*", created_tasks=" + created_tasks +*/
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof User)){
            return false;
        }
        return id == ((User)o).id;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
