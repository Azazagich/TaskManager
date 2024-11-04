package org.example.taskmanager.service.dto;

public class RegisterUserDTO {

    private String email;

    private String password;

    private String firstName;

    public RegisterUserDTO() { }

    public String getEmail() {
        return email;
    }

    public RegisterUserDTO email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public RegisterUserDTO password(String password) {
        this.password = password;
        return this;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public RegisterUserDTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
