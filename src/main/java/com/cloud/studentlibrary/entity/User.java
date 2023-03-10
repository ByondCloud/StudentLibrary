package com.cloud.studentlibrary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/9
 * @Time 17:05
 */
@Data
@NoArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Integer UserId;
    private String UserName;
    private String UserPassword;
    private Integer UserAge;
    private String UserEmail;

    public User(String userName, int userAge, String userEmail) {
        UserName = userName;
        UserAge = userAge;
        UserEmail = userEmail;
    }
}
