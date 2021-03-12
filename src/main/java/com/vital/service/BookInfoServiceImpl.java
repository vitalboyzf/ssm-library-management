package com.vital.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.vital.dao.BookInfoMapper;
import com.vital.po.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {
    @Autowired
    private BookInfoMapper bookinfoDao;

    @Override
    public PageInfo<BookInfo> queryBookInfoAll(BookInfo bookInfo, int page, int limit) {
        //设置当前页以及每页记录数
        PageHelper.startPage(page, limit);
        //获取所有记录信息
        List<BookInfo> list = bookinfoDao.queryBookInfoAll(bookInfo);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;

    }

    @Override
    public int addBookSubmit(BookInfo info) {
        return bookinfoDao.insert(info);
    }

    @Override
    public int updateBookSubmit(BookInfo info) {
        return bookinfoDao.updateByPrimaryKey(info);
    }

    @Override
    public BookInfo queryBookInfoById(Integer id) {
        return bookinfoDao.queryBookInfoById(id);
    }

    @Override
    public int deleteBookInfoById(List<String> ids) {
        for (String id : ids) {
            bookinfoDao.deleteBookInfoById(Integer.valueOf(id));
        }
        return 1;
    }

    @Override
    public List<BookInfo> getBookCountByType() {
        return bookinfoDao.getBookCountByType();
    }
}
