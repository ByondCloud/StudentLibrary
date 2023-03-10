package com.cloud.studentlibrary.service;

import com.cloud.studentlibrary.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/9
 * @Time 17:10
 */
public interface UserService {

    List<User> getUserList();

    User selectUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);




}
