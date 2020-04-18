package com.miaojl.dao;

import com.miaojl.entity.Detail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DetailMapper extends Mapper<Detail> {


    /*@SelectProvider(type=DetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="work_order_id", property="workOrderId", jdbcType=JdbcType.BIGINT),
        @Result(column="waste_type_id", property="wasteTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="waste_id", property="wasteId", jdbcType=JdbcType.BIGINT),
        @Result(column="component", property="component", jdbcType=JdbcType.VARCHAR),
        @Result(column="weight", property="weight", jdbcType=JdbcType.REAL),
        @Result(column="morphological", property="morphological", jdbcType=JdbcType.VARCHAR),
        @Result(column="packaging", property="packaging", jdbcType=JdbcType.VARCHAR),
        @Result(column="plate_number", property="plateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    List<Detail> selectByExample(DetailExample example);*/

    @SelectProvider(type=DetailSqlProvider.class, method="selectByWorkId")
    List<Detail> selectByWorkId(Integer id);
}