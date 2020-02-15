package app.servlets;

import app.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ChatServlet", urlPatterns = "/chat")
public class ChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if(u == null)
        {
            req.setAttribute("result", "You must be logged in, to use public chat");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

        req.setAttribute("user", u);
        req.getRequestDispatcher("viewjsp/chat.jsp").forward(req, resp);
    }
}
