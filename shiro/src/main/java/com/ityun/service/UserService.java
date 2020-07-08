package com.ityun.service;

import com.ityun.bean.User;

public interface UserService {
    public User findByName(String name);
}
