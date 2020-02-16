package app.entities;

import java.util.Date;

public class Message {
    private String message;
    private Date date_of_post;
    private String author;

    public Message(String message, Date date_of_post, String author) {
        this.message = message;
        this.date_of_post = date_of_post;
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate_of_post() {
        return date_of_post;
    }

    public void setDate_of_post(Date date_of_post) {
        this.date_of_post = date_of_post;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
