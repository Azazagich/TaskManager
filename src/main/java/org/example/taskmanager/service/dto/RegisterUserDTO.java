//package org.example.taskmanager.service.dto;
//
//import java.io.Serializable;
//import java.util.Objects;
//
//public class RegisterUserDTO implements Serializable {
//    private String email;
//
//    private String password;
//
//    private String fullName;
//
//    public RegisterUserDTO(){ }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getFullName() {
//        return fullName;
//    }
//
//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    @Override
//    public String toString() {
//        return "RegisterUserDTO{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", fullName='" + fullName + '\'' +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        RegisterUserDTO that = (RegisterUserDTO) o;
//        return Objects.equals(email, that.email) &&
//                Objects.equals(password, that.password) &&
//                Objects.equals(fullName, that.fullName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(email, password, fullName);
//    }
//}
