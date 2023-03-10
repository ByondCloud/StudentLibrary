package com.cloud.studentlibrary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/10
 * @Time 15:16
 */

@Data
@NoArgsConstructor
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer bookId;
    private String bookName;
    private BigDecimal bookPrice;

    public Book(String bookName, BigDecimal bookPrice) {
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }
}
