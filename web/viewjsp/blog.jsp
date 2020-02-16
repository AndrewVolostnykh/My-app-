<%@ page import="app.entities.Message" %>
<%@ page import="java.util.List" %>\
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
<div style="margin-left: 2%">
    <h3>Blog of <%out.print(request.getAttribute("name"));%></h3>
</div>
<% if(request.getAttribute("newMessage") != null)
{
    out.print("<div class=\"w3-container w3-padding\">" +
            "<form method=\"post\" class=\"w3-selection w3-light-grey w3-padding\">" +
            "<label>Create new Post:" +
            "<textarea name=\"message\" class=\"w3-input w3-border\" style=\"resize:none\"></textarea>" +
            "</label>\n" +
            "<br>" +
            "<input type=\"text\" hidden name=\"author\" value=\"" + request.getAttribute("name") + "\"/>" +
            "<button class=\"w3-btn w3-indigo w3-round-large w3-margin-bottom\" type=\"submit\">Submit</button>" +
            "    </form>\n" +
            "</div>");
}
%>
<div style="margin-left: 2%; margin-right: 2%">
<% List<Message> messages = (List<Message>)request.getAttribute("messagesList");

    if (messages!=null && !messages.isEmpty())
    {
        for(int i = messages.size() -1; i >= 0; i--)
        {
            out.print("<div class=\"w3-card-4\">");
            out.print("<div class=\"w3-container\">");
            out.print("<p>" + messages.get(i).getMessage() + "</p>");
            out.print("<p>" + messages.get(i).getDate_of_post() + "</p>");
            out.print("</div></div>");
            out.print("<br>");
        }
    } else {
        out.print("<h3> Here no posts yet <h3>");
    }
%>
</div>
<!--
<div class="w3-container w3-padding">
    <form method="post" class="w3-selection w3-light-grey w3-padding">
        <label>Create new Post:
        <textarea name="message" class="w3-input w3-border" style="resize:none"></textarea>
        </label>
        <br>
        <input type="text" hidden name="author" value="<%//out.print(request.getAttribute("name"));%>"/>
        <button class="w3-btn w3-indigo w3-round-large w3-margin-bottom" type="submit">Submit</button>
    </form>
</div>



            out.print("<div class=\"w3-card-4\">");
            out.print("<div class=\"w3-container\">");
            out.print("<p>" + message.getMessage() + "</p>");
            out.print("<p>" + message.getDate_of_post() + "</p>");
            out.print("</div></div>");
            out.print("<br>");
-->
<!--Div with blog messages-->


</body>
</html>
