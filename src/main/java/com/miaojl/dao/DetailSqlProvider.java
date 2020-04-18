package com.miaojl.dao;

import org.apache.ibatis.jdbc.SQL;

/**
 * @author mjl
 * @date 2020/4/16
 * @description
 */
public class DetailSqlProvider {

    public String selectByWorkId(Integer id){
        SQL sql = new SQL();
        sql.SELECT("de.*,wt.code waste_type_code ,wt.name waste_type_name,wa.code waste_code");
        sql.FROM("detail de,waste_type wt,waste wa");
        sql.WHERE("de.work_order_id=#{id}");
        sql.WHERE("de.waste_type_id=wt.id");
        sql.WHERE("de.waste_id=wa.id");

        return sql.toString();
    }

}
