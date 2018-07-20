<%-- 
    Document   : listofapartment
    Created on : Jul 8, 2018, 6:10:52 PM
    Author     : Bishal Shrestha
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Rooms</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body >
        <div class="container-login100" style="background-image: url('images/background.jpg');" </div>
        <h2>List Of Hostels</h2>

        <div class="container">
            <%String path=request.getServletContext().getContextPath()+"/images/";%>
            <c:forEach items="${list}" var="x">


                <!--                <div class="row">-->
                <div class="col-md-4">

                    <div class="thumbnail" >
                        <a href="${x.filename}" target="_blank">
                            <img src="<%=path%>${x.filename}" alt="Lights" class="img-thumbnail" alt="Chania" style="height:300px;width: 450px">
                            <div class="caption">
                                <p>${x.name}</p>
                            </div>
                        </a>

                        <p>${x.owner}</p>
                        <p>${x.location}</p>
                        <p>${x.price}</p>
                        <p>${x.name}</p>
                     
                        <a class="btn btn-success" href="bookNow.jsp">Book Now</a>  
                    </div>
                </div>

                <!--</div>-->




            </c:forEach>
                
        </div>



    </body>
</html>


