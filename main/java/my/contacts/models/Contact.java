package my.contacts.models;

import jakarta.persistence.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name="contact")
public class Contact {
    private Integer user_id;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer contact_id;
    private String first_name, last_name, phone, photo;

    public Contact(){}

    public Contact(Integer user_id, Integer contact_id, String first_name, String last_name, String phone, String photo) {
        this.user_id = user_id;
        this.contact_id = contact_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.photo = photo;
    }

    public Contact(ResultSet rs) throws SQLException {
        this.user_id = rs.getInt("user_id");
        this.contact_id = rs.getInt("contact_id");
        this.first_name = rs.getString("first_name");
        this.last_name = rs.getString("last_name");
        this.phone = rs.getString("phone");
        this.photo = rs.getString("photo");
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "user_id=" + user_id +
                ", contact_id=" + contact_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
