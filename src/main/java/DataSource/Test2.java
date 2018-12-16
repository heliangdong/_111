package DataSource;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by Administrator on 2018/12/9.
 */
public class Test2 {
    @Test
    public void mytest1() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        // 1.创建自定义连接池对象
        MyDataSource dataSource = new MyDataSource();
        try {
            // 2.从池子中获取连接
            conn = dataSource.getConnection();
            String sql = "insert into tbl_user values(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "1004");
            pstmt.setString(2, "貂蝉");
            pstmt.setString(3, "123456");
            pstmt.setString(4, "girl");
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("添加成功!");
            } else {
                System.out.println("添加失败!");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            dataSource.backConnection(conn);
        }
    }
}
