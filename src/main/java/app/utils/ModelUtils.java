package app.utils;

import app.entities.User;
import app.model.Model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelUtils {
    private static Model model = new Model();

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

    public synchronized static List<String> listOfUsers() // dont work
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
}
