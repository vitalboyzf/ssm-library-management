package com.vital.dao;

import com.vital.po.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    // 根据id删除管理员
    int deleteAdminById(Integer id);

    // 添加管理员
    int insert(Admin record);

    // 根据id查询管理员
    Admin queryAdminById(Integer id);

    // 修改管理员信息
    int updateByPrimaryKey(Admin record);

    // 查询所有管理员
    List<Admin> queryAdminInfoAll(Admin admin);

    // 根据用户名和密码查询用户信息
    Admin queryUserByNameAndPassword(@Param("username") String username, @Param("password") String password);
}