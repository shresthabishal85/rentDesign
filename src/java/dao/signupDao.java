/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import static java.time.Clock.system;
import util.dbConnection;

/**
 *
 * @author Bishal Shrestha
 */
public class signupDao {

    dbConnection db = new dbConnection();

    public boolean input(String name, String location, String username, String password) {
        System.out.println(name);
        try {
            PreparedStatement pstmt = db.cn.prepareStatement("insert into login(name,location,username,password) values(?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, location);
            pstmt.setString(3, username);
            pstmt.setString(4, password);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println(result);
                return true;
            }else{
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

}
