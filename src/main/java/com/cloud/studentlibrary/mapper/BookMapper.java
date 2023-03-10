package com.cloud.studentlibrary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.studentlibrary.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ByondCloud
 * @version 1.0
 * @Date 2023/3/10
 * @Time 18:44
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
