<%-- 
    Document   : login
    Created on : 29 Apr 2022, 5:29:07 pm
    Author     : matthewsorbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login | IoT Bay</title>
        <link rel="stylesheet" type="text/css" href="static/css/login.css">
    </head>
    <body>
        <div class="login">
            <div class="loginContents">
                <h2 id="title"><b>Login</b></h2>
                <form class="loginForm" action="LoginServlet" method="post">
                    <div class="loginFormElement" id="email">
                        <label>Email</label>
                        <div>
                            <input class="border-customized-input" type="text" required="true" name="email" placeholder="john@smith.com">
                        </div>
                    </div>
                    <div class="loginFormElement" id="password">
                        <label>Password</label>
                        <div>
                            <input class="border-customized-input" type="password" required="true" name="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="buttons">
                        <a href="home.jsp" class="cancel">Cancel</a>
                        <button class="submit" type="submit">Login</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
