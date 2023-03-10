package com.cloud.studentlibrary.service.impl;

import com.cloud.studentlibrary.entity.User;
import com.cloud.studentlibrary.mapper.UserMapper;
import com.cloud.studentlibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/9
 * @Time 17:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
        return users;
    }

    @Override
    public User selectUserById(int id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteById(id);
    }
}
