package app.servlets;

import app.entities.User;
import app.model.Model;
import app.utils.ModelUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if (session.getAttribute("email") != null)
        {
            req.setAttribute("name", u.getName());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();

        if (session.getAttribute("email") == null) { // check are user have already logged in
            String email = req.getParameter("email");
            String password = req.getParameter("pass");

            Model model = new Model();
            model.setConnection();
            User user = ModelUtils.loginUser(email, password); // special util that checking user registration

            if (user != null) { // check are user input correct email and pass
                if (ModelUtils.isActive(user.getEmail())) { // check are user account activate
                    session.setAttribute("email", user);
                    req.setAttribute("name", user.getName());
                    req.setAttribute("result", "Welcome " + user.getName());
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                } else {
                    req.setAttribute("fail", "You must activate your profile. ");
                    doGet(req, resp);
                }
            } else {
                req.setAttribute("fail", "Incorrect email or password. ");
                doGet(req, resp);
            }
        } else {
            req.setAttribute("fail", "You must log out at first. ");
            doGet(req, resp);
        }

    }
}
