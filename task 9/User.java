package com.quizapp.model;

import java.util.Date;

public class User {
    public int userId;
    public String username;
    public String email;
    public String password;
    public Role role;
    public Date createdAt;

    public enum Role { Student, Instructor }
}
