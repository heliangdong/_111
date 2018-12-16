package DataSource;

import org.junit.Test;
import utils.C390Utils;
import utils.DBCPUtils;
import utils.JDBCUtils_V3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2018/12/16.
 */
public class DBCPUtilstest {

    @Test
    public void testdbcp(){
        Connection conn=null;
        PreparedStatement pstmt=null;

        conn= DBCPUtils.getConnection();
        String sql = "insert into tbl_user values(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,"10016");
            pstmt.setString(2,"吕布");
            pstmt.setString(3,"789456");
            pstmt.setString(4,"man");
            int row=pstmt.executeUpdate();
            if(row>0){
                System.out.print("你使用的是C3P0，执行SQL成功");
            }else {
                System.out.print("使用失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils_V3.release(conn,pstmt,null);
        }

    }
}
