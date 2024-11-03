package org.example.taskmanager.defaultSecurity;

import org.example.taskmanager.domain.User;

public class RegisterUserDTO {
    private String email;

    private String password;

    private String firstName;

    public RegisterUserDTO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegisterUserDTO email(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterUserDTO password(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public RegisterUserDTO firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
}
