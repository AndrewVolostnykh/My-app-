package app.servlets;

import app.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;


//un-usable servlet at this moment
@WebServlet(name = "UserProfile", urlPatterns = {"/profile"})
public class UserProfile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");

        if(session.getAttribute("email") == null)
        {
            req.setAttribute("redirection", "You must login.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.setAttribute("name", u.getName());
            req.setAttribute("email", u.getEmail());
            req.setAttribute("id", u.getId());
            req.setAttribute("country", u.getCountry());
            req.setAttribute("birthday", u.getBirthDate());
            req.setAttribute("gender", u.getGender());

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/profile.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
