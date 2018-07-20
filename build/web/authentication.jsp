<%-- 
    Document   : authentication
    Created on : Jul 5, 2018, 5:52:32 AM
    Author     : Bishal Shrestha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username=request.getParameter("username");
            String pass=request.getParameter("pass");  
        %>
        <%
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/rentdesign","root","");
PreparedStatement pstmt=cn.prepareStatement("select*from login where username=? and password=?");
pstmt.setString(1,username);
pstmt.setString(2,pass);
ResultSet rs=pstmt.executeQuery();
if(rs.next())
{
    session.setAttribute(username,"username");
    response.sendRedirect("welcome.jsp");
}                  
else
{
     response.sendRedirect("login.jsp?msg=invalid try");
}
                          
        }
        catch(Exception ex){
      out.println(ex);
      
        %>
    </body>
</html>
