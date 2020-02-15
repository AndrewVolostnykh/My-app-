<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>User profile | My app:)</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            a { text-decoration: none; }
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
        <div class="w3-container w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-blue">
                    <h2>Edit profile</h2>
                </div>
            <form method="post" action="/webattempt_war_exploded/update_profile" class="w3-selection w3-light-grey w3-padding">
                <label>New name:
                    <input type="text" name="name" class="w3-input w3-animate-input w3-border w3-round-large"
                           value="<%out.print(request.getAttribute("user"));%>"
                           style="width: 30%"/>

                </label>
                <br>

                <input type="text" hidden name="email" value="<%out.print(request.getAttribute("email"));%>"/>

                <button class="w3-btn w3-blue w3-round-large w3-margin-bottom" type="submit">Submit</button>
            </form>
            </div>
            <br>
        </div>

        <div class="w3-container w3-light-grey w3-padding w3-right-align">
        </div>
        <footer><h1><a href="/webattempt_war_exploded/have_problem">Have any problem? Click on me!</a></h1></footer>
    </body>
</html>