package org.example.taskmanager.defaultSecurity;


    public class LoginUserDto {
        private String email;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public LoginUserDto() {
        }

        private String password;
    }

