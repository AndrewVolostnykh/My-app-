package app.model;

import app.entities.User;

import java.sql.*;

// In this class written all request-methods of DB
// Cause my DB is not so big, i've dont singled out UserDao and ActivationDao
/*In this class i using synchronized methods, this id bad practice (synchronized
 * using more machine-resources than ReentrantLocker for ex.), but this project created for have
 * own social-network with my friends, and will not use by many people.*/
public class Model {
    private Connection connection = null;

    public synchronized void setConnection() {
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
    // ======================User block ===========================================//
    public synchronized void insertNewUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into \"User\"(\"name\", \"email\", " +
                    "\"password\", \"country\", \"birthDate\", \"gender\", \"active\") values (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getCountry());
            preparedStatement.setString(5, user.getBirthDate());
            preparedStatement.setString(6, user.getGender());
            preparedStatement.setBoolean(7, user.isActive());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized void deleteFromUser(String email)
    {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from \"User\" where email = " + "'" + email + "';");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized ResultSet selectFromUser(String email)
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

    public synchronized ResultSet selectAllFromUser()
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

    public synchronized void updateUserActive(String email, String column, boolean value)
    {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update \"User\" set \"" + column + "\"=" + value + " where email='" + email +"';");
        } catch (SQLException e)
        {
            System.err.println("LOG(Model/UpdU): Warning, "+e);
        }
    }

    public synchronized void updateUser(String email, String column, String value)
    {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("update \"User\" set \"" + column + "\"='" + value + "' where email='" + email +"';");
        } catch (SQLException e)
        {
            //System.err.println("LOG(Model/UpdU): Warning, "+e);
            e.printStackTrace();
        }
    }
// ======================Activation block ===========================================//
    public synchronized ResultSet selectFromActivation(String email)
    {
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("select * from \"Activation\" where email = '" + email + "';");
        } catch (SQLException e)
        {
            System.err.println("LOG: Warning, " + e);
        }
        return null;
    }

    public synchronized void insertIntoActivation(String email, String activationCode)
    {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into \"Activation\"(\"email\", \"activationCode\") values (?,?);");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, activationCode);
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            System.err.println("LOG(Model/insActiv): Warning, " + e);
        }
    }

    public synchronized void deleteFromActiovation(String email)
    {
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from \"Activation\" where email = " + "'" + email + "';");
        } catch (SQLException e)
        {
            System.err.println("LOG(Model/delActiv): Warning, " + e);
        }
    }
    // ======================Blog block ===========================================//

    public synchronized ResultSet selectFromBlog(String blogauthor)
    {
        try{
            Statement statement = connection.createStatement();
            return statement.executeQuery("select * from \"Blog\" where \"blogAuthor\" = '" + blogauthor + "';");
        } catch(SQLException e)
        {
            System.err.println("LOG(blog): Warning, " + e);
        }
        return null;
    }

    public synchronized void insertIntoBlog(String blogauthor, String message, long dateOfPost)
    {
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into \"Blog\"(\"blog_message\",\"date_of_post\",\"blogAuthor\") " +
                                                                                            "values (?,?,?);");
            preparedStatement.setString(1, message);
            preparedStatement.setDate(2, new Date(dateOfPost));
            preparedStatement.setString(3, blogauthor);
            preparedStatement.executeUpdate();

        } catch(SQLException e)
        {
            System.err.println("LOG(blog): Warning, " + e);
        }
    }

    public synchronized void deleteFromBlog(String blogauthor, Date dateOfPost)
    {
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("delete from \"Blog\" where blogAuthor = '" + blogauthor + "' and date_of_post = '" + dateOfPost + "';");
        } catch(SQLException e)
        {
            System.err.println("LOG(blog): Warning, " + e);
        }
    }


}