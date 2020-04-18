package com.miaojl.dao;

import com.miaojl.entity.WorkOrder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface WorkOrderMapper extends Mapper<WorkOrder> {


    /*@SelectProvider(type=WorkOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="transport_user_id", property="transportUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="recipient_user_id", property="recipientUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
    })
    List<WorkOrder> selectByExample(WorkOrderExample example);*/

    @SelectProvider(type=WorkOrderSqlProvider.class, method="selectByCondition")
    List<WorkOrder> selectByCondition(Map<String,Object> params);
}