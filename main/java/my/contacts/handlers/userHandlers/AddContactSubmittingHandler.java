package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;
import my.contacts.database.hibernate.dao.ContactDAO;
import my.contacts.models.Contact;
import my.contacts.models.User;
import org.apache.commons.io.FileUtils;

import java.io.*;

public class AddContactSubmittingHandler implements Handler {

    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.formParam("first_name");
        String last_name = context.formParam("last_name");
        String phone = context.formParam("phone");
        String photo = "";
        UploadedFile file = context.uploadedFile("upload_photo");
        if(file.getFilename() != null && !(file.getFilename().equals(""))){
            photo = file.getFilename();
            InputStream is = file.getContent();
            File images_file = new File(System.getenv("JAVA_RESOURCES") + "/my_contacts/static/contacts_images/" + photo);
            FileUtils.copyInputStreamToFile(is, images_file);
        }
        User user = (User) context.sessionAttribute("user");
        Contact contact = new Contact(user.getUser_id(), null, first_name, last_name, phone, photo);
        int generated_id = ContactDAO.save(contact);
        if (generated_id > 0) {
            context.redirect("/?SaveContact=true");
        } else {
            context.redirect("/?SaveContact=false");
        }
    }
}
