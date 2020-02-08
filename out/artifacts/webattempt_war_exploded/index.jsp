<%@ page import="app.entities.User" %><%--
  Created by IntelliJ IDEA.
  User: zigha
  Date: 07.02.2020
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>My app:)</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            a { text-decoration: none; }
        </style>
    </head>
    <body class="w3-light-grey">
        <!-- header -->
        <div class="w3-container w3-indigo w3-right-align">
            <h1><a href="/webattempt_war_exploded/index.jsp">My app :)</a></h1>

            <% User u = (User)session.getAttribute("email"); // taking information from current session to say hello entered user.
            if(request.getAttribute("name")!=null)
            {
                out.print("<h5 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/profile\">Welcome, "+ request.getAttribute("name") +"</a></h5>");
            } else if (u != null){
                out.print("<h3 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/login\">Welcome, " + u.getName() + "</a></h3>");
            } else {
                out.print("<h3 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/login\">Login</a></h3>");
            }%>
        </div>

        <% /*
        if(request.getAttribute("redirection") != null)
        {
            out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-grey w3-border w3-border-sand w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getAttribute("redirection") + "</h5>\n" +
                    "</div>");
        }

        if(request.getAttribute("loginRedirect") != null)
        {
            out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-grey w3-border w3-border-sand w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getAttribute("loginRedirect") + "</h5>\n" +
                    "</div>");
        }
        */
         if(request.getAttribute("result") != null)
        {
            out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-grey w3-border w3-border-sand w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getAttribute("result") + "</h5>\n" +
                    "</div>");
        }

        %>

        <br>
            <div class="w3-container w3-center">
                <h3>
                    Hi! I'm simple web application.
                </h3>
                    I have written on Java with Servlets, JSP, JDBC(PostgreSQL) and love.
                <p>Here u can:</p>p>
                        >Create yourself profile.
                        >Login
                        >Logout or delete this profile
                    In future u will can:
                        >Edit your profile
                        >Where create profile on email will sent message with validation link.
                        >Add photo
                        >Take communication in public chat
                    Thank u that stopped by ;)

            </div>
        <br>

        <div class="w3-container w3-center">       <!-- content -->
            <div>    <!-- buttons holder -->
                <button class="w3-btn w3-grey w3-round-large" onclick="location.href='/webattempt_war_exploded/list'">List users</button>
                <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/webattempt_war_exploded/add'">Registration</button>
                <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/webattempt_war_exploded/login'">Login</button>
                <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/webattempt_war_exploded/profile'">Profile</button>
            </div>
        </div>
    </body>
</html>
