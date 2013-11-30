package com.parents.checklist.dao;

import org.springframework.stereotype.Repository;

import com.parents.GenericDaoImpl;
import com.parents.checklist.model.User;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoImpl<User, Long> {

    public User findByUsername(String username) {
        User example = new User();
        example.setUsername(username);
        return findOneByExample(example);
    }
}
