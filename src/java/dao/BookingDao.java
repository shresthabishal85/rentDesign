package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.dbConnection;

/**
 *
 * @author Bishal Shrestha
 */
public class BookingDao {

    dbConnection db = new dbConnection();

    public boolean book(String building,int id, String username) throws SQLException {
        System.out.println("booking"+building+" id " + id + "by user " + username);
        PreparedStatement pstmt = db.cn.prepareStatement("insert into booking(username,type,id) values(?,?,?)");
        pstmt.setString(1, username);
        pstmt.setString(2, building);
        pstmt.setInt(3, id);
        int result = pstmt.executeUpdate();
        if (result > 0) {
            return (true);
        }
        return (false);
    }

   }
