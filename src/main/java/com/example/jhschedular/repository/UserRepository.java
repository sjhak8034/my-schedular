package com.example.jhschedular.repository;

import com.example.jhschedular.entity.User;

public interface UserRepository {
    User registerUser(User entity);

    User editUser(User entity);
}
