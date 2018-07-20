<%-- 
    Document   : room.jsp
    Created on : Jul 8, 2018, 12:42:06 PM
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
        <form action="RoomController1?act=location" method="POST">
            <input type="text" name="location" placeholder="enter the location">
            <input type="submit" value="submit">
        </form>
        
    </body>
</html>
