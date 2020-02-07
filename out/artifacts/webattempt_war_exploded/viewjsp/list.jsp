<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Users | My app:)</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <style>
            a { text-decoration: none; }
        </style>
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-right-align w3-indigo" >
            <h1><a href="/webattempt_war_exploded/index.jsp">My app :)</a></h1>
            <%if(request.getAttribute("name")!=null)
            {
                out.print("<h5 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/profile\">Welcome, "+ request.getAttribute("name") +"</a></h5>");
            } else {
                out.print("<h3 class=\"w3-text-sand \"><a href=\"/webattempt_war_exploded/login\">Login</a></h3>");
            }%>
        </div>

        <div class="w3-container w3-center w3-margin-bottom w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-blue">
                    <h2>List of Users</h2>
                </div>

                    <%
                        List<String> names = (List<String>)request.getAttribute("userNames");

                        if (names != null && !names.isEmpty()) {
                            out.println("<ul class=\"w3-ul\">");
                            for (String s : names) {
                                out.println("<li class=\"w3-hover-sand\">" + s + "</li>");
                            }
                            out.println("</ui>");
                        } else out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4 w3-round\">\n"
                                +

                                "   <h5>There are no users yet!</h5>\n" +
                                "</div>");
                    %>
                <!--                      "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                                "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-red w3-border w3-border-red w3-hover-border-grey\">×</span>\n" + -->
            </div>
        </div>

        <div class="w3-container w3-light-grey w3-opacity w3-right-align w3-padding">
        </div>

    </body>
</html>
