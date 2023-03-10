package com.cloud.studentlibrary.controller;

import com.cloud.studentlibrary.entity.User;
import com.cloud.studentlibrary.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/9
 * @Time 16:51
 */
@RestController
@RequestMapping("/User")
@CrossOrigin
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping({"/getUserList", "/getList", "/UserList"})
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }

    // 通过url传参
    @GetMapping("/addUser")
    public void addUser(@RequestParam("userName") String name, Integer userAge, String userEmail) {
        // 判空操作
        System.out.println(name);
        System.out.println(userAge);
        System.out.println(userEmail);

        User user = new User(name, userAge, userEmail);
        userService.addUser(user);
    }

    // 通过JSON传参
    @PostMapping("/updateUser")
    public void updateUser(@RequestBody User user) {
        System.out.println(user);
        userService.updateUser(user);
    }

    @GetMapping("/deleteUser")
    public void deleteUser(int id) {
        userService.deleteUser(id);
    }






}
