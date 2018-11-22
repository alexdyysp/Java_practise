package tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class JDBCUtils {
    /*
    获取数据库连接
    dbcp连接池
     */
    private static BasicDataSource datasource = new BasicDataSource();//创建basicdatasource
    static {
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://localhost:3306/gjp?useSSL=false");
        datasource.setUsername("root");
        datasource.setPassword("123456");
        datasource.setMaxActive(10);
        datasource.setMaxIdle(5);
        datasource.setMinIdle(2);
        datasource.setInitialSize(10);
    }
    public static DataSource getDataSource(){
        return datasource;
    }
}
