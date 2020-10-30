package com.demo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * @ClassName: HiveDemo
 * @Author: djsoft wpf
 * @Description: HiveDemo
 * @Date: 2020/10/29 16:27
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HiveTest {

    private static final Logger logger = LoggerFactory.getLogger(HiveTest.class);

    @Autowired
    @Qualifier("hiveDruidDataSource")
    DataSource druidDataSource;

    @Test
    public void showTables(){
        StringBuffer sql = new StringBuffer("");
        sql.append("show tables");
        logger.info("Running: " + sql);
        try {
            Statement statement = druidDataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                System.err.println(resultSet.getString(1));
            }
            logger.info("show table successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showTablesRecord(){
        StringBuffer sql = new StringBuffer("");
        //hive数据库中的表名
        sql.append("select * from pokes");
        logger.info("Running: " + sql);
        try {
            Statement statement = druidDataSource.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                ResultSetMetaData metaData = resultSet.getMetaData();
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.err.println(resultSet.getString(i));
                }
            }
            logger.info("show table successfully...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
