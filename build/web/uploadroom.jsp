<%-- 
    Document   : uploadroom
    Created on : Jul 8, 2018, 1:31:36 PM
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
        <form action="RoomController1?act=uproom" method="post" enctype="Multipart/form-data">
            Owner's name:<input type="text" name="owner" placeholder="enter name" required=""><br>
            Location:<input type="text" name="location" placeholder="location of room" required=""><br>
            Price:<input type="number" name="price" placeholder="price of the room" required=""><br>
            <input type="file" name="filename" required="       "><br>
            <input type="submit" value="upload">
        </form>
    </body>
</html>
