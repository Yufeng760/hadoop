package com.demo.test;

import org.apache.hadoop.hbase.*;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @ClassName: HbaseDemo
 * @Author: djsoft wpf
 * @Description: HbaseDemo
 * @Date: 2020/10/29 11:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HbaseTest {

    /**
     * 获取连接
     * @return
     * @throws IOException
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //获取hbase配置类对象
            Configuration config = new Configuration();
            //配置hbasezookeeper集群地址
            config.set("hbase.zookeeper.quorum", "192.168.235.145:2181,192.168.235.146:2181,192.168.235.147:2181");// zookeeper地址
            conn = ConnectionFactory.createConnection(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭连接
     * @param conn
     * @throws IOException
     */
    public static void close(Connection conn) throws IOException {
        if(conn!=null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Test
    public void testHbase() throws IOException {
        Connection connection = getConnection();
        try {
            //获取连接管理对象
            Admin admin = connection.getAdmin();
            //获取集群主机
            ServerName master = admin.getMaster();
            System.err.println("=============主机名==================\n"+master.getHostname());
            System.err.println("============主机地址=================\n"+master.getAddress());
            System.err.println("=============端口号==================\n"+master.getPort());
            //获取test表
            Table table = connection.getTable(TableName.valueOf("test"));
            System.err.println("==============表对象=================\n"+table);
            System.err.println("==============表描述=================\n"+table.getDescriptor());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            close(connection);
        }
    }
}
