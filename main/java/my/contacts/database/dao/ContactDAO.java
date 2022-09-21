package my.contacts.database.dao;

import my.contacts.database.DBConnection;
import my.contacts.models.Contact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactDAO {

    public static Contact get(int contact_id) throws SQLException {
        String query = String.format("SELECT * FROM `contact` WHERE `contact_id`=%d", contact_id);
        PreparedStatement ps = DBConnection.get().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            return new Contact(rs);
        }
        return null;
    }

    public static List<Contact> getAll(int userId){
        List<Contact> contacts = new ArrayList<>();
        String query = String.format("SELECT * FROM `contact` WHERE `user_id`=%d ORDER BY `first_name`", userId);
        try{
            PreparedStatement ps = DBConnection.get().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contact c = new Contact(rs);
                contacts.add(c);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return contacts;
    }

    public static List<Contact> getForPhrase(int userId, String phrase){
        List<Contact> contacts = getAll(userId);
        List<Contact> filteredContacts = new ArrayList<>();
        phrase = phrase.toLowerCase();
        for(Contact c : contacts){
            if(c.getFirst_name().toLowerCase().contains(phrase)
               || c.getLast_name().toLowerCase().contains(phrase)
               || c.getPhone().contains(phrase)){
                filteredContacts.add(c);
            }
        }
        return filteredContacts;
    }



    public static int save(Contact contact){
        int result = 0;
        try{
            String query = """
                    INSERT INTO `contact`(`user_id`, `first_name`, `last_name`, `phone`, `photo`)
                    VALUES (?,?,?,?,?);""";
            PreparedStatement ps = DBConnection.get().prepareStatement(query);
            ps.setInt(1, contact.getUser_id());
            ps.setString(2, contact.getFirst_name());
            ps.setString(3, contact.getLast_name());
            ps.setString(4, contact.getPhone());
            ps.setString(5, contact.getPhoto());
            result = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int edit(Contact contact){
        int result = 0;
        String query = """
                UPDATE `contact` SET `first_name`=?,`last_name`=?,`phone`=?, `photo`=?
                WHERE `contact_id`=?;""";
        try {
            PreparedStatement ps = DBConnection.get().prepareStatement(query);
            ps.setString(1, contact.getFirst_name());
            ps.setString(2, contact.getLast_name());
            ps.setString(3, contact.getPhone());
            ps.setString(4, contact.getPhoto());
            ps.setInt(5, contact.getContact_id());
            result = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    public static int delete(int id){
        int result = 0;
        try{
            String query = String.format("DELETE FROM `contact` WHERE `contact_id`=%d", id);
            PreparedStatement ps = DBConnection.get().prepareStatement(query);
            result = ps.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
}

