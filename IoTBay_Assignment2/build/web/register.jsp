<%-- 
    Document   : register
    Created on : 29 Apr 2022, 5:39:23 pm
    Author     : matthewsorbara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register | IoT Bay</title>
        <link rel="stylesheet" type="text/css" href="static/css/register.css">
    </head>
     <body>
        <div class="register">
            <div class="registerContents">
                <h2 id="title"><b>Register</b></h2>
                <form class="registerForm" action="RegisterServlet" method="post">
                    <div class="registerFormElement" id="name">
                        <label>Full Name</label>
                        <div>
                            <input class="border-customized-input" type="text" required="true" name="name" placeholder="Full Name">
                        </div>
                    </div>
                    <div class="registerFormElement" id="email">
                        <label>Email</label>
                        <div>
                            <input class="border-customized-input" type="text" required="true" name="email" placeholder="Email">
                        </div>
                    </div>
                    <div class="registerFormElement" id="password">
                        <label>Password</label>
                        <div>
                            <input class="border-customized-input" type="password" required="true" name="password" placeholder="Password">
                        </div>
                    </div>
                    <div class="registerFormElement" id="phone">
                        <label>Phone</label>
                        <div>
                            <input class="border-customized-input" type="text" required="true" name="phone" placeholder="Phone">
                        </div>
                    </div>
                    <div class="buttons">
                        <a href="home.jsp" class="cancel">Cancel</a>
                        <button class="submit" type="submit">Register</button>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
