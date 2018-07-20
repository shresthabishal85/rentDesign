<!doctype html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.username== null}">
    <c:redirect url="index.jsp?msg=you must login first"></c:redirect>
    </c:if>
<html lang=''>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/styles.css">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="script.js"></script>
        <title>WELCOME</title>
    </head>
    <body>

        <div id='cssmenu'>
            <ul>
                <li><a href='rooms.jsp'><span>ROOMS</span></a></li>
                <li><a href='apartments.jsp'><span>APARTMENTS</span></a></li>
                <li><a href='hostels.jsp'><span>HOSTELS</span></a></li>
                <div class="dropdown">
                    <button class="dropbtn" >Upload
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="dropdown-content">
                        <a href="uploadroom.jsp">Rooms</a>
                        <a href="uploadappartments.jsp">Appartments</a>
                        <a href="uploadhostels.jsp">Hostels</a>
                    </div>
                </div>

            </ul>
        </div>
        <a href="MyController1?msg=logout">LOGOUT</a>
        
        <style>
            body
            {
                background-image: url("img/room.jpg");
                background-repeat: no-repeat ;
                background-size :  100% 900px; 

            }
        </style>
    </body>
    <html>