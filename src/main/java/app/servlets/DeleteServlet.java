package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Model model = new Model();
        model.setConnection();
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("email");

        if (u != null) {
            model.deleteFromUser(u.getEmail());

            session.removeAttribute("email");
            req.setAttribute("result", "It's so sad that you go out, " + u.getName());
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }

    }
}