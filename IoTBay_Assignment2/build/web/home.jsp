<%-- 
    Document   : home
    Created on : 29 Apr 2022, 5:49:54 pm
    Author     : matthewsorbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | IoT Bay</title>
        <link rel="stylesheet" type="text/css" href="static/css/home.css">
    </head>
    <body>
        <div class="home">
            <div class="homeContents">
                <div class="homeForm">
                    <h2 id="title"><b>IoT Bay Home</b></h2>
                    <div class="buttons">
                        <a href="login.jsp" class="submit">Login</a>
                        <a href="register.jsp" class="submit">Register</a>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="/ConnectionServlet" flush="true" />
    </body>
</html>
