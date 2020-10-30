package com.demo.properties;

/**
 * @ClassName: HiveProperties
 * @Author: djsoft wpf
 * @Description: HiveProperties，连接hive数据库的基本参数
 * @Date: 2020/10/30 13:01
 */
public class HiveProperties {

    /**
     * hive数据仓库地址
     */
    public static String URL="jdbc:hive2://master:10000";
    /**
     * hive驱动名称
     */
    public static String DRIVER_CLASSNAME="org.apache.hive.jdbc.HiveDriver";
    /**
     * hive元数据用户名
     */
    public static String USERNAME="root";
    /**
     * hive元数据库用户密码
     */
    public static String PASSWORD="root";
    /**
     * 连接池配置——初始连接池创建的连接数量
     */
    public static Integer INITIALSIZE=1;
    /**
     * 连接池配置——最小连接数
     */
    public static Integer MIN_IDLE=3;
    /**
     * 连接池配置——最大连接数
     */
    public static Integer MAX_ACTIVE=20;
    /**
     * 连接池配置——等待超时时间
     */
    public static Integer MAX_WAIT=60000;
    /**
     * 连接池配置——检测连接池需要关闭的连接的间隔时间
     */
    public static Integer TIME_BETWEEN_EVICTION_RUNS_MILLIS=60000;
    /**
     * 连接池配置——连接在池中的最小生存时间
     */
    public static Integer MIN_EVICTABLE_IDLE_TIME_MILLIS=30000;
    /**
     * 以下统称其他参数，官网的参数描述太长了，不想写
     */
    public static String VALIDATION_QUERY="select 1";
    public static Boolean TEST_WHILE_IDLE=true;
    public static Boolean TEST_ONBORROW=false;
    public static Boolean TEST_ONRETURN=false;
    public static Boolean POOL_PREPAREDSTATEMENTS=true;
    public static Integer MAX_POOL_PREPAREDSTATEMENT_PERCONNECTIONSIZE=20;

}
