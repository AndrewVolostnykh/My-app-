package app.servlets;

import app.model.Model;
import app.utils.ModelUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmailVerificationServlet", urlPatterns = "/verification")
public class EmailVerificationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        Model model = new Model();
        model.setConnection();

        if(ModelUtils.activationCodeCheck(email, code)) { // method that check code and email matching
            model.updateUserActive(email, "active", true); // if code correct - set account activation on "true"
            req.setAttribute("result", "Successfully activated! ");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            req.setAttribute("result", "Activation code incorrect. ");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
