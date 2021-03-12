package com.vital.dao;

import com.vital.po.BookInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookInfoMapper {
    // 根据id删除图书信息
    void deleteBookInfoById(Integer id);

    // 添加书籍信息
    int insert(BookInfo record);

    // 根据id查询图书信息
    BookInfo queryBookInfoById(Integer id);

    // 根据关键字更新图书信息
    int updateByPrimaryKey(BookInfo record);

    // 查询所有的图书信息
    List<BookInfo> queryBookInfoAll(BookInfo info);

    // 根据图书的类型获取图书的数量
    List<BookInfo> getBookCountByType();
}