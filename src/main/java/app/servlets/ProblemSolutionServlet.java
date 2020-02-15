package app.servlets;

import app.entities.User;
import app.model.Model;
import app.utils.ModelUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ProblemSolutionServlet", urlPatterns = "/have_problem")
public class ProblemSolutionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if (session.getAttribute("email") != null)
        {
            req.setAttribute("name", u.getName());
        }

        req.getRequestDispatcher("viewjsp/have_problem.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deleting_email = req.getParameter("deleting_email");
        String deleting_pass = req.getParameter("deleting_pass");

        String oldemeil = req.getParameter("oldemail");
        String oldpass = req.getParameter("oldpass");
        String newpass = req.getParameter("newpass");

        if(deleting_email != null)
        {
            Model model = new Model();
            model.setConnection();

            if(ModelUtils.loginUser(deleting_email, deleting_pass) != null)
            {
                model.deleteFromUser(deleting_email);
                req.setAttribute("result", "Success! Now you can create new account with same email!");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                req.setAttribute("result", "Input date incorrect or empty.");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        } else if (oldemeil != null & newpass != null)
        {
            Model model = new Model();
            model.setConnection();

            if(ModelUtils.loginUser(oldemeil, oldpass) != null)
            {
                model.updateUser(oldemeil, "password", newpass);
                HttpSession session = req.getSession();
                session.removeAttribute("email");
                req.setAttribute("result", "Success! Your pass changed. Login now.");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } else {
                req.setAttribute("result", "Input date incorrect or empty");
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("result", "One or more fields left empty");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
