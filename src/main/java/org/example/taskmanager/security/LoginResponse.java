package org.example.taskmanager.security;

public class LoginResponse {

    private String token;

    private long expiresIn;

    public void setToken(String token) {
        this.token = token;
    }

    public LoginResponse token(String token) {
        this.token = token;
        return this;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public LoginResponse expiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
        return this;
    }

    public String getToken() {
        return token;
    }
}
