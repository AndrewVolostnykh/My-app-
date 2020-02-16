package app.servlets;

import app.dao.BlogDao;
import app.entities.Message;
import app.entities.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BlogServlet", urlPatterns = "/blog")
public class BlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String blogauthor = req.getParameter("blogauthor");

        HttpSession session = req.getSession();
        User user = (User)session.getAttribute("email");
        if(user != null)
        {
            BlogDao blogDao = new BlogDao();
            req.setAttribute("name", user.getName());

            if(blogauthor == null)
            {
                // take from model datas
                // if data is empty - show button to write first post
                // if data not empty - show field to write new post and show all other posts
                List<Message> messagesList = blogDao.getMessages(user.getName());
                req.setAttribute("messagesList", messagesList);
                req.setAttribute("name", user.getName());
                req.setAttribute("newMessage", "true");

                req.getRequestDispatcher("viewjsp/blog.jsp").forward(req,resp);
            } else {
                // taking data for current blog author
                List<Message> messagesList = blogDao.getMessages(blogauthor);
                req.setAttribute("messagesList", messagesList);
                
                req.setAttribute("name", blogauthor);
                req.getRequestDispatcher("viewjsp/blog.jsp").forward(req,resp);
            }
        } else {
            req.setAttribute("result", "You must be logged in");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String message = req.getParameter("message");
        String author = req.getParameter("author");

        if(message.length() < 30)
        {
            req.setAttribute("result", "To short message! Tell to us more (Min 30 symbols)");
            req.getRequestDispatcher("viewjsp/blog.jsp").forward(req, resp);
        } else {
            BlogDao blogDao = new BlogDao();
            blogDao.insertMessage(author, message);
            req.setAttribute("result", "Success. Refresh page to see new message!");
            doGet(req, resp);
        }
    }
}
