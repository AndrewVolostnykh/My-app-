package app.servlets;

import app.entities.User;
import app.model.Model;

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

        String email = req.getParameter("email");
        String password = req.getParameter("pass");

        Model model = Model.getInstance();
        User user = model.findUser(email, password);

        HttpSession session = req.getSession();

        if(user != null)
        {
            session.setAttribute("email", user);
            req.setAttribute("name", user.getName());
            req.setAttribute("loginRedirect", "Welcome " + user.getName());
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } else {
            req.setAttribute("fail", "Incorrect email or password. ");
            doGet(req, resp);
        }
    }
}
