package org.example.taskmanager.defaultSecurity;

public class LoginResponce {
    private String token;

    private long expiresIn;

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponce token(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public LoginResponce expiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getToken() {
        return token;
    }
}
