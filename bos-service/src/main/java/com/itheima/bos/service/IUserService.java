package com.itheima.bos.service;

import com.itheima.bos.domain.User;

public interface IUserService {
    public User login(User user);

    void editPassword(String id, String password);
}
