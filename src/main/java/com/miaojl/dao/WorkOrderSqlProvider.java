package com.miaojl.dao;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * @author mjl
 * @date 2020/4/15
 * @description
 */
public class WorkOrderSqlProvider {

    public String selectByCondition(Map<String,Object> params){
        SQL sql = new SQL();
        sql.SELECT("wo.*," +
                "cu.name create_user_name,cu.phone create_user_phone,co.name create_office_name," +
                "tu.name transport_user_name,tu.phone transport_user_phone,`to`.name transport_office_name," +
                "ru.name recipient_user_name,ru.phone recipient_user_phone,ro.name recipient_office_name");
        sql.FROM("work_order wo");
        sql.LEFT_OUTER_JOIN("sys_user cu  on wo.create_user_id=cu.id",
                "sys_office co on cu.office_id=co.id",
                "sys_user tu on wo.transport_user_id=tu.id",
                "sys_office `to` on tu.office_id=`to`.id",
                "sys_user ru  on wo.recipient_user_id=ru.id",
                "sys_office ro on ru.office_id=ro.id");
        sql.WHERE("wo.del_flag=0");

        if(params.containsKey("startDate")&& !StringUtils.isEmpty(params.get("startDate"))){
            sql.WHERE("DATE(wo.create_date)>=#{startDate}");
        }
        if(params.containsKey("endDate")&& !StringUtils.isEmpty(params.get("endDate"))){
            sql.WHERE("DATE(wo.create_date)<=#{endDate}");
        }
        if(params.containsKey("status")&& !StringUtils.isEmpty(params.get("status"))){
            sql.WHERE("wo.status = #{status}");
        }
        if(params.containsKey("officeId")&& !StringUtils.isEmpty(params.get("officeId"))){
            sql.WHERE("(co.id=#{officeId} or `to`.id=#{officeId} or ro.id=#{officeId})");
        }

        return sql.toString();
    }

}
