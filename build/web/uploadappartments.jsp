<%-- 
    Document   : uploadappartments
    Created on : Jul 8, 2018, 5:13:02 PM
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
         <form method="post" action="apartController?msg=upload" enctype="Multipart/form-data">
            <table>
                <tr>
                    <td>NAME OF OWNER</td>
                    <td> <input type="text" name="owner" required=""></td>
                    
                </tr>
                 <tr>
                    <td>LOCATION</td>
                    <td> <input type="text" name="location" placeholder="location of apartment" required=""></textarea></td>
                    
                </tr>
                    
                <tr>
                    <td>PHOTO</td>
                    <td><input type="file" name="file" required=""></td>
                </tr>
                <tr>
                 
                    <td>price</td>
                    <td><input type="number" name="price" required=""></td>
                    
                </tr>
                <tr>
                    <td>NAME</td>
                    <td><input type="text" name="name" placeholder="name of apartment" required=""></td>
                </tr>
                <tr>
                    <td><input type="submit" value="upload" required=""></td>
                </tr>
                
            </table>
           <br><br>
            <br>
        </form>
    </body>
</html>
