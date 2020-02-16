package app.dao;

import app.entities.Message;
import app.model.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogDao {
    public List<Message> getMessages(String authorName)
    {
        List<Message> listOfMessages = new ArrayList<>();

        Model model = new Model();
        model.setConnection();
        ResultSet set = model.selectFromBlog(authorName);

        try {
            while (set.next()) {
                listOfMessages.add(new Message(set.getString("blog_message"),
                                                set.getDate("date_of_post"),
                                                set.getString("blogAuthor")));
            }
        } catch (Exception e)
        {
            System.err.println("LOG(BlogDao): Warning, " + e);
        }

        return listOfMessages;
    }

    public void insertMessage(String author, String message)
    {
        Model model = new Model();
        model.setConnection();
        System.out.println(author);
        java.util.Date date = new Date();
        date.getTime();

        model.insertIntoBlog(author, message, date.getTime());
    }

}
