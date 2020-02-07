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

        <div class="w3-container" style="width:50%">
            <div class="w3-card-4">
                <header class="w3-container w3-blue">
                    <h2><%out.print(request.getAttribute("name"));%></h2>
                </header>
                <div class="w3-container">
            <%
                out.print("<h4 class=\"w3-light-grey\">Email: "+request.getAttribute("email") + "</h4>");
                out.print("<br><h4 class=\"w3-light-grey\">ID: " + request.getAttribute("id") + "</h4>");
                out.print("<br><h4 class=\"w3-light-grey\">Country: " + request.getAttribute("country") + "</h4>");
                out.print("<br><h4 class=\"w3-light-grey\">Birthday: " + request.getAttribute("birthday") + "</h4>");
                out.print("<br><h4 class=\"w3-light-grey\">Gender: " + request.getAttribute("gender") + "</h4>");
            %>
                </div>
                <footer class="w3-container w3-blue">
                    <br>
                </footer>
            </div>
        </div>


        <div class="w3-container w3-light-grey w3-opacity w3-right-align w3-padding">
        </div>
    </body>
</html>
