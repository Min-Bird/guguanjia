package com.miaojl.dao;

import com.miaojl.entity.Qualification;
import com.miaojl.entity.QualificationCondition;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface QualificationMapper extends Mapper<Qualification> {

//    @SelectProvider(type=QualificationSqlProvider.class, method="selectByExample")
//    @Results({
//        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
//        @Result(column="upload_user_id", property="uploadUserId", jdbcType=JdbcType.BIGINT),
//        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
//        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
//        @Result(column="check", property="check", jdbcType=JdbcType.INTEGER),
//        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
//        @Result(column="check_user_id", property="checkUserId", jdbcType=JdbcType.BIGINT),
//        @Result(column="create_date", property="createDate", jdbcType=JdbcType.TIMESTAMP),
//        @Result(column="update_date", property="updateDate", jdbcType=JdbcType.TIMESTAMP),
//        @Result(column="del_flag", property="delFlag", jdbcType=JdbcType.VARCHAR),
//        @Result(column="create_by", property="createBy", jdbcType=JdbcType.VARCHAR)
//    })
//    List<Qualification> selectByExample(QualificationExample example);

    @SelectProvider(type = QualificationSqlProvider.class,method = "selectByCondition")
    List<Qualification> selectByCondition(QualificationCondition condition);

}