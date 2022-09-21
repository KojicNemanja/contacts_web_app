package my.contacts.database.dao;

import my.contacts.database.DBConnection;
import my.contacts.models.User;
import my.contacts.utils.HashUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

    public static int save(User user){
        int result = 0;
        try {
            String query = """
                    INSERT INTO `user`(`first_name`, `last_name`, `username`, `password`)
                    VALUES (?,?,?,?);""";
            Connection conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, user.getFirst_name());
            ps.setString(2, user.getLast_name());
            ps.setString(3, user.getUsername());
            ps.setString(4, HashUtil.passwordToHash(user.getPassword()));
            result = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static User getForUsername(String username){
        try{
            String query = String.format("SELECT * FROM `user` WHERE `username`='%s'", username);
            Connection conn = DBConnection.get();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(rs);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
