package org.example.service;

import org.example.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public void save(User user);

    public void delete(int id);

    User findByName(String name);


}
