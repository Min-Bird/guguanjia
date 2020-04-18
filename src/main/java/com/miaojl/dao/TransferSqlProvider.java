package com.miaojl.dao;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author mjl
 * @date 2020/4/16
 * @description
 */
public class TransferSqlProvider {

    public String selectByWorkId(Integer id){
        SQL sql = new SQL();

        sql.SELECT("tr.*,su.name user_name ,su.phone user_phone");
        sql.FROM("transfer tr,sys_user su");
        sql.WHERE("tr.work_order_id=#{id}");
        sql.WHERE("tr.oprate_user_id=su.id");
        sql.ORDER_BY("tr.create_date desc");

        return sql.toString();
    }

}
