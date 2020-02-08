package app.model;

import app.entities.User;

import java.sql.*;

public class Model {
    private Connection connection = null;

    public void setConnection() {
        try {
            String name = "postgres";
            String pass = "1679438520";
            String dburl = "jdbc:postgresql://localhost:5432/my_app";
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(dburl, name, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception oe) {
            System.err.println("LOG: Warning, " + oe);
        }
    }

    public void insertNewUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into \"User\"(\"name\", \"email\", " +
                    "\"password\", \"country\", \"birthDate\", \"gender\") values (?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.setString(5, user.getBirthDate());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delteFromUser(String email)
    {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from \"User\" where email = " + "'" + email + "';");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public ResultSet selectFromUser(String email)
    {
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("select * from \"User\" where email = '" + email + "';");
        } catch (SQLException e)
        {
            System.err.println("LOG: Warning, " + e);
        }
        return null;
    }

    public ResultSet selectAllFromUser()
    {
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("select * from \"User\"");
        } catch (Exception e)
        {
            System.err.println("LOG(MODEL/SELECTALL): Warning, " + e);
        }
        return null;
    }
}