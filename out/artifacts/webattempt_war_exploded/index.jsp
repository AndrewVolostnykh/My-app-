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
                out.print("<h3 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/profile\">Welcome, " + u.getName() + "</a></h3>");
            } else {
                out.print("<h3 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/login\">Login</a></h3>");
            }%>
        </div>

        <%
         if(request.getAttribute("result") != null)
        {
            out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-grey w3-border w3-border-sand w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getAttribute("result") + "</h5>\n" +
                    "</div>");
        }

        %>
        <!-- Description of this project -->
        <div class="w3-row">
            <div class="w3-col m3 w3-center"><p>   </p></div>
            <div class="w3-col m6 ">
                <p><h2>Hi! Welcome to me.</h2>
                <p>I`m simple application.</p>
                <p>Please, register here, confirm your email,
                and test this web site. My developer will be very thankful for this :) </p>
            </div>
            <div class="w3-col m3 w3-center"><p>   </p></div>
        </div>
        <br>

        <div class="w3-container w3-center">
            <div>    <!-- buttons holder -->
                <button class="w3-btn w3-grey w3-round-large" onclick="location.href='/webattempt_war_exploded/list'">List users</button>
                <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/webattempt_war_exploded/add'">Registration</button>
                <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/webattempt_war_exploded/login'">Login</button>
                <button class="w3-btn w3-blue w3-round-large" onclick="location.href='/webattempt_war_exploded/profile'">Profile</button>
            </div>
        </div>
    </body>
</html>
