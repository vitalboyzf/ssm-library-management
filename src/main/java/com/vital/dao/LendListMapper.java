package com.vital.dao;

import com.vital.po.LendList;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("lendListDao")
public interface LendListMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lend_list
     *
     * @mbggenerated Sun Jun 21 16:29:22 CST 2020
     */
    int insert(LendList record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table lend_list
     *
     * @mbggenerated Sun Jun 21 16:29:22 CST 2020
     */
    int insertSelective(LendList record);

    /**
     * 查询借阅记录
     */
    List<LendList> queryLendListAll(LendList lendList);


    /**
     * 查询当前用户已经借了多少本信息
     */
    int queryLendNumberById(Integer id);

    /**
     * 删除
     */
    int deleteLendListById(Integer id);

    /**
     * 还书
     */
    int updateLendListSubmit(LendList lendList);

    /**
     * 查询时间线
     */
    List<LendList> queryLookBookList(@Param("rid") Integer rid,@Param("bid") Integer bid);
}