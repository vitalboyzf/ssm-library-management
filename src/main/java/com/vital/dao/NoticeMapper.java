package com.vital.dao;

import com.vital.po.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {
    // 添加公告
    int insert(Notice record);

    // 查询所有公告
    List<Notice> queryNoticeAll(@Param("content") String content);

    // 删除公告
    void deleteNoticeByIds(List<Integer> id);

    // 查询详细根据id查询
    Notice queryNoticeById(Integer id);
}