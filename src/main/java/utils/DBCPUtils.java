package utils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Administrator on 2018/12/16.
 */
public class DBCPUtils {
    private static javax.sql.DataSource dataSource;

    static {

        //加载properties文件输入流
        InputStream is=DBCPUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
        //加载输入流
        Properties props=new Properties();

            props.load(is);
         //创建数据源
                dataSource= BasicDataSourceFactory.createDataSource(props);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static DataSource getDatasource(){
        return (DataSource) dataSource;
    }

    public static Connection getConnection(){
        try {
            return  dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








}
