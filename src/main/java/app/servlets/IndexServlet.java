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

@WebServlet(name = "IndexServlet", urlPatterns = "/welcome")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if (session.getAttribute("email") != null)
        {
            req.setAttribute("name", u.getName());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/index.jsp");
        requestDispatcher.forward(req, resp);
    }
}
