<%--
  Created by IntelliJ IDEA.
  User: zigha
  Date: 15.02.2020
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
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
        <div class="w3-container w3-padding"> <h3>I want to help you, with your problem.</h3>
            <form method="post" class="w3-selection w3-light-grey w3-padding">
            <p>If you have registered but email have no message, you can delete old profile and create new, input only your old email and password: </p>

            <label>E-mail:
                <input type="text" name="deleting_email" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
            </label>
            <br>

            <label>Password:
                <input type="password" name="deleting_pass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
                <br>
                <button class="w3-btn w3-indigo w3-round-large w3-margin-bottom" type="submit">Submit</button>
            </form>
        </div>
        <div class="w3-container w3-padding">
            <form method="post" class="w3-selection w3-light-grey w3-padding">
            <p>Or, if you want to change password, you can input here your email, old and new pass. </p>

            <label>E-mail:
                <input type="text" name="oldemail" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%">
            </label>
            <br>
            <label>Old Password:
                <input type="password" name="oldpass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
            <label>New Password:
                <input type="password" name="newpass" class="w3-input w3-animate-input w3-border w3-round-large" style="width: 30%"><br />
            </label>
                <br>
                <button class="w3-btn w3-indigo w3-round-large w3-margin-bottom" type="submit">Submit</button>
            </form>

            If this all have no help to you - write in my telegram @TheMadAndrew
        </div>
    </body>
</html>
