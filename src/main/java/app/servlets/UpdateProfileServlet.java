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

@WebServlet(name = "UpdateProfile", urlPatterns = "/update_profile")
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if (session.getAttribute("email") != null)
        {
            req.setAttribute("user", u.getName());
            req.setAttribute("email", u.getEmail());
        } else {
            req.setAttribute("result", "You must login. ");
            req.getRequestDispatcher("viewjsp/index.jsp").forward(req, resp);
        }

        req.getRequestDispatcher("viewjsp/updateProfile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String name = req.getParameter("name");

        System.out.println(name + " and " + email);

        Model model = new Model();
        model.setConnection();

        if(model.selectFromUser(email) != null)
        {
            model.updateUser(email, "name", name);
            req.setAttribute("result", "Success, " + name + ". You must re-login, to see your new name");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else {
            req.setAttribute("result", "Wow its a problem. You may be not logged in?");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
