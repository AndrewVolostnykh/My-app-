package app.utils;

import app.entities.User;
import app.model.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.mail.Authenticator;

public class ModelUtils {
    private static Model model = new Model();

    /**Deprecated method, that was check are same user
     * already saved in DB*/
    public synchronized static boolean checkDuplication(User user) // not using
    {
        try {
            model.setConnection();
            ResultSet set = model.selectFromUser(user.getEmail());
            if (set.next())
            {
               return true;
            }
        } catch (Exception e)
        {
            System.err.println("LOG(checkDuplication) Warning, " + e);
        }
        return false;
    }

    /**This method taking user from DB with same email and password*/
    public synchronized static User loginUser(String email, String password)
    {
        try {
            model.setConnection();
            ResultSet set = model.selectFromUser(email);
            if (set.next()) {
                if(set.getString("password").equals(password))
                return new User(set.getString("name"), set.getString("password"), set.getString("email") , set.getString("country"), set.getString("birthDate"), set.getString("gender"));
            }
        } catch (Exception e)
        {
            System.err.println("LOG(loginUser): Warning, " + e);
        }
        return null;
    }

    /**This method checking are user account have activated:
     *  if yes -> return true
     *  else -> return false*/
    public synchronized static boolean isActive(String email)
    {
        try {
            model.setConnection();
            ResultSet set = model.selectFromUser(email);
            if (set.next()) {
                if (set.getBoolean("active")) return true;
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }

    /**Method that taking list of users from DB*/
    public synchronized static List<String> listOfUsers()
    {
        List<String> list = new ArrayList<>();
        String[] temp = new String[6];
        try {
            model.setConnection();
            ResultSet set = model.selectAllFromUser();
            while (set.next()) {
                int i = 1;
                while(i <= 2)
                {
                    temp[i-1] = set.getString(i);
                    i++;
                }
                temp[i-1] = set.getString(i);
                list.add(temp[0] + ", " + temp[1]);
            }
            return list;
        } catch (Exception e){
            System.err.println("LOG(MODELUTILS/listOfUsers): Warning, " + e);
        }
        return null;
    }

    /**This method create activation code (bad practice), save this in DB
     * and call method to send message with this code*/
    public synchronized static void setActivationCode(String email)
    {
        Model model = new Model();
        model.setConnection();

        String activationCode = UUID.randomUUID().toString();

        model.insertIntoActivation(email, activationCode);
        EmailUtil.sendMessage(email, activationCode);
    }

    /** This method using in EmailValidationServlet
     * Created for check code that saved on DB by email that inputted in "get line"
     * with code that inputted in "get" of EmailVerificationServlet
     *
     * return true if activation code valid*/
    public synchronized static boolean activationCodeCheck(String email, String code)
    {
        try {
            model.setConnection();
            ResultSet set = model.selectFromActivation(email);
            if(set.next())
            {
                if(set.getString("activationCode").equals(code)) return true;
            }
        } catch (SQLException e)
        {
            System.err.println("LOG(MUtils/activeCheck): Warning, " + e);
        }
        return false;
    }
}
