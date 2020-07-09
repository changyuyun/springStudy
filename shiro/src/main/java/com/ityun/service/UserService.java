package com.ityun.service;

import com.ityun.bean.User;

public interface UserService {
    User findByName(String name);
    User findById(Integer id);
}
