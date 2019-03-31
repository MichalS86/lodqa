package com.lodqa;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DbManager {

    MysqlDataSource mysqlDS = new MysqlDataSource();
    JdbcTemplate jdbcTemplate;

    public DbManager() {
        mysqlDS.setURL("jdbc:mysql://mysql15.mydevil.net:3306/m1148_lodqa");
        mysqlDS.setUser("m1148_lodqa");
        mysqlDS.setPassword("lodQa159");
        jdbcTemplate = new JdbcTemplate(mysqlDS);
    }

    public void removeGeometryFromDb() {
        jdbcTemplate.update("DELETE FROM geometry;");
    }
}
