/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import model.Apartment;
import model.Rooms;
import util.dbConnection;

/**
 *
 * @author Bishal Shrestha
 */
public class RoomDao {

    dbConnection db = new dbConnection();

    public void fileupload(HttpServletRequest request, String owner, String location, String price, String filename) throws SQLException {
        try {
            PreparedStatement pstmt = db.cn.prepareStatement("insert into room(owner,location,price,filename) values(?,?,?,?)");
            pstmt.setString(1, owner);
            pstmt.setString(2, location);
            pstmt.setString(3, price);
            pstmt.setString(4, filename);

            pstmt.executeUpdate();
            //System.out.println(pstmt.executeUpdate());

        } catch (Exception exp) {
            System.out.println(exp);
        }
    }

    public List<Rooms> getRooms(String location) {
        List<Rooms> list = new ArrayList<Rooms>();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentdesign", "root", "");
            PreparedStatement pstmt = cn.prepareStatement("select*from room where location=?");
            pstmt.setString(1, location);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Rooms g = new Rooms();
                g.setId(rs.getInt(1));
                g.setOwner(rs.getString(2));
                g.setLocation(rs.getString(3));
                g.setPrice(rs.getString(4));
                g.setFilename(rs.getString(5));
                g.setBooked(rs.getInt(6));
                list.add(g);
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }

        return list;

    }

    public boolean bookedRoom(int id) {
        try {
            PreparedStatement pstmt = db.cn.prepareStatement("update room set booked=? where id=?");
            pstmt.setInt(1, 1);
            pstmt.setInt(2,id);
            int res = pstmt.executeUpdate();
            if (res > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
        
    }

}
