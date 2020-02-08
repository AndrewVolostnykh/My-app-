package app.servlets;

import app.entities.User;
import app.utils.ModelUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

// handing queries by /list
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if (session.getAttribute("email") != null)
        {
            req.setAttribute("name", u.getName());
        }

        List<String> stringList = ModelUtils.listOfUsers();
        req.setAttribute("userNames", stringList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
