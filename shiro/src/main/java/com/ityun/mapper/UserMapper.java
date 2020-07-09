package com.ityun.mapper;

import com.ityun.bean.User;

public interface UserMapper {
    User findByName(String name);
    User findById(Integer id);
}
