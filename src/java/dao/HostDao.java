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
import javax.servlet.http.HttpServletRequest;
import model.Apartment;
import model.Hostels;
import model.Rooms;
import static org.eclipse.jdt.internal.compiler.parser.Parser.name;
import util.dbConnection;

/**
 *
 * @author Bishal Shrestha
 */
public class HostDao {

    dbConnection db = new dbConnection();


    public void fileupload(HttpServletRequest request, String owner, String name, String filename, String location,String price) throws SQLException {
        try {
            PreparedStatement pstmt = db.cn.prepareStatement("insert into hostel(owner,price,filename,location,name) values(?,?,?,?,?)");
            pstmt.setString(1, owner);
            pstmt.setString(2, price);
            pstmt.setString(3, filename);
            pstmt.setString(4, location);
            pstmt.setString(5, name);
            
            pstmt.executeUpdate();
            

        } catch (Exception exp) {
            System.out.println(exp);
        }
    }
    public List<Hostels> getHostels(String location) {
        List<Hostels> list = new ArrayList<Hostels>();
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentdesign", "root", "");
            PreparedStatement pstmt = cn.prepareStatement("select*from hostel where location=?");
            pstmt.setString(1, location);
            ResultSet rs = pstmt.executeQuery();
    
           
           
            while (rs.next()) {
                Hostels g = new Hostels();
                g.setId(rs.getInt(1));
                g.setOwner(rs.getString(2));
                g.setLocation(rs.getString(3));
                g.setPrice(rs.getString(4));
                g.setFilename(rs.getString(5));
                g.setName(rs.getString(6));
     
                list.add(g);
            }
        } catch (Exception exp) {
            System.out.println(exp);
        }

        return list;
    
    }  

  
   
}
