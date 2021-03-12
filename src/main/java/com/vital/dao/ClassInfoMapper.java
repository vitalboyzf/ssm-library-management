package com.vital.dao;

import com.vital.po.ClassInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("classDao")
public interface ClassInfoMapper {
    /**
     * 查询所有的记录信息
     */
    List<ClassInfo> queryClassInfoAll(@Param(value = "name") String name);

    /**
     * 添加图书类型
     */
    void addTypeSubmit(ClassInfo info);

    /**
     * 修改 根据id查询记录信息
     */
    ClassInfo queryClassInfoById(Integer id);

    /**
     * 修改提交
     */
    void updateTypeSubmit(ClassInfo info);

    /**
     * 根据ids删除记录信息
     */
    void deleteTypeByIds(List<Integer> id);
}
