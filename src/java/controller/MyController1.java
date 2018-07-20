/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.signupDao;
import java.io.*;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bishal Shrestha
 */
public class MyController1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = request.getParameter("msg");
        if (msg.equals("logout")) {
            request.getSession().invalidate();
            response.sendRedirect("index.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String check = request.getParameter("act");
        if (check.equals("login")) {
            String username = request.getParameter("username");
            String pass = request.getParameter("pass");

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentdesign", "root", "");
                PreparedStatement pstmt = cn.prepareStatement("select*from login where username=? and password=?");
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    request.getSession().setAttribute("username",username);
                    response.sendRedirect("welcome.jsp");
                } else {
                    response.sendRedirect("login.jsp?msg=invalid");
                }

            } catch (Exception ex) {
                out.println(ex);

            }

        }
        if (check.equals("signup")) {
            signupDao dao = new signupDao();
            String name = request.getParameter("name");
            String location = request.getParameter("location");
            String username = request.getParameter("username");
            String password = request.getParameter("pass");

            if(dao.input(name, location, username, password))
            response.sendRedirect("login.jsp");
            else
            response.sendRedirect("signup.jsp");
        }
    }
}
