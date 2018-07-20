<%-- 
    Document   : signup
    Created on : Jul 5, 2018, 10:48:13 AM
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
        <form action="MyController1?act=signup" method="post">
            Name      : <input type="text" required name="name"><br><br>
            Address   : <input type="text" required name="location"><br><br>
            Username  : <input type="text" required name="username"><br><br>
            Password  : <input type="password" required name="pass"><br><br>
            <input type="submit" value="REGISTER"  name="submit">
        </form>
    </body>
</html>
