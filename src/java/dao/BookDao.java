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
import static org.apache.tomcat.jni.User.username;
import util.dbConnection;

/**
 *
 * @author Bishal Shrestha
 */
public class BookDao {
    dbConnection db=new dbConnection();
    public void store() throws ClassNotFoundException, SQLException
    {
         try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentdesign", "root", "");
            PreparedStatement pstmt = cn.prepareStatement("select*from login where username=?");
            pstmt.setString(1,"username");
            ResultSet rs = pstmt.executeQuery();
    }
         catch(Exception ex)
         {}
    
}
}
