<%@ page import="app.entities.User" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Update Profile | My app:)</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            a { text-decoration: none; }
            .footer {
                position: fixed;
                left: 0;
                bottom: 0;
                width: 100%;
                background-color: #2196F3;
                color: white;
                text-align: center;
            }
        </style>
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-indigo w3-right-align">
            <h1><a href="/webattempt_war_exploded/index.jsp">My app :)</a></h1>
            <%if(request.getAttribute("name")!=null)
            {
                out.print("<h5 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/profile\">Welcome, "+ request.getAttribute("name") +"</a></h5>");
            } else {
                out.print("<h3 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/login\">Login</a></h3>");
            }%>
        </div>
        <br><br>
        <% User user = (User)request.getAttribute("user");
        String currentName = user.getName();
        String currentBirth = user.getBirthDate();
        %>
        <div class="w3-container w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-blue">
                    <h2>Edit profile</h2>
                </div>
            <form method="post" action="/webattempt_war_exploded/update_profile" class="w3-selection w3-light-grey w3-padding">
                <label>New name:
                    <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large"
                           value="<%out.print(currentName);%>"
                           style="width: 30%"/>
                </label>
                <label>New Birthday:<br>
                    <input type="date" name="birthday" class="w3-date"
                           value="<%out.print(currentBirth);%>"
                           style="width: 30%"/>
                </label>
                <br><br>
                <input type="text" hidden name="email" value="<%out.print(request.getAttribute("email"));%>"/>

                <button class="w3-btn w3-blue w3-round-large w3-margin-bottom" type="submit">Submit</button>
            </form>
            </div>
            <br>
        </div>

        <div class="w3-container w3-light-grey w3-padding w3-right-align">
        </div>
        <footer class="footer">
            <h3><a href="/webattempt_war_exploded/have_problem">Have any problem? Click on me!</a></h3>
        </footer>
    </body>
</html>