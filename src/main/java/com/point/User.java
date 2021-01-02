package com.point;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.xml.crypto.Data;
import java.util.Date;
public class User {
        String email;
        String name;
        String password;
        int Authority;
        Date Register_time;

        public User(String email, String password) {
                this.email = email;
                this.password = password;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getAuthority() {
                return Authority;
        }

        public void setAuthority(int authority) {
                Authority = authority;
        }

        public Date getRegister_time() {
                return Register_time;
        }

        public void setRegister_time(Date register_time) {
                Register_time = register_time;
        }

        public Date getLast_login_time() {
                return last_login_time;
        }

        public void setLast_login_time(Date last_login_time) {
                this.last_login_time = last_login_time;
        }

        Date last_login_time;
        public User(String email,String name,String password,int Authority,Date last_login_time){
                this.email=email;
                this.name=name;
                this.password=password;
                this.Authority=Authority;
                this.last_login_time=last_login_time;
        }
}
