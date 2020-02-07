<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Login | My app:)</title>
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

        <!-- Display information about failure login -->
        <% if(request.getAttribute("redirection") != null)
        {
            out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-grey w3-border w3-border-sand w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getAttribute("redirection") + "</h5>\n" +
                    "</div>");
        }
            if(request.getAttribute("fail") != null)
        {
            out.println("<div class=\"w3-panel w3-sand w3-display-container w3-card-4\">\n" +
                    "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                    "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-grey w3-border w3-border-sand w3-hover-border-grey\">×</span>\n" +
                    "   <h5>" + request.getAttribute("fail") + "</h5>\n" +
                    "</div>");
        }%>

        <div class="w3-container w3-padding">
            <div class="w3-container w3-center w3-blue">
                <h2>Login</h2>
            </div>
        <form method="post" class="w3-selection w3-light-grey w3-padding">
            <label>E-mail:
                <input type="text" name="email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
            </label>
            <br>

            <label>Password:
                <input type="password" name="pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <br>

            <button class="w3-btn w3-blue w3-round-large w3-margin-bottom" type="submit">Submit</button>
        </form>
            <!--
            <div class="w3-container w3-light-grey w3-opacity w3-right-align w3-padding">
                <button class="w3-btn w3-round-large" onclick="location.href='/webattempt_war_exploded/'">Back to main</button>
            </div>
            -->
        </div>
    </body>
</html>

