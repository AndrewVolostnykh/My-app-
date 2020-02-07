package app.servlets;

import app.entities.User;
import app.model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// handing queries by /add
public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // CREATED ONLY FOR TESTING //
        User user = new User("Andrij Volostnykh", "123456789", "zighalt790@gmail.com", "Ukraine", null, "male");
        Model model = Model.getInstance(); model.add(user); // ONLY FOR TESTING !
        // CREATED ONLY FOR TESTING //

        HttpSession session = req.getSession();
        User u = (User)session.getAttribute("email");
        if (session.getAttribute("email") != null)
        {
            req.setAttribute("name", u.getName());
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("viewjsp/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8"); // using to correct save input data

        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String country = req.getParameter("country");
        String date = req.getParameter("birthday"); // check, does it works

        User user = new User(name, password, email, country, date, gender);
        Model model = Model.getInstance();

        String validation = validator(user); // string that have message about fail validation

        if(validation == null) {
            if (model.duplicationCheck(user)) // block duplications
            {
                req.setAttribute("result", " User with same e-mail already registered! ");
                doGet(req, resp);
            } else {
                model.add(user);

                req.setAttribute("result", "Done! " + name + " registered! :)");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("result", validation);
            doGet(req, resp);
        }
    }

    private String validator(User u) // validator returns message or null if validation passed successful
    {
        if(u.getName().length() < 8)
        {
            return "Your name too short. (May be more/equal than 8 symbols)";
        } else if (!u.getEmail().matches("^(.+)@(.+)$"))
        {
            return "Incorrect email";
        } else if (u.getPassword().length() < 8)
        {
            return "Your password too short. (May be more/equal than 8 symbols)";
        }
        return null;
    }
}