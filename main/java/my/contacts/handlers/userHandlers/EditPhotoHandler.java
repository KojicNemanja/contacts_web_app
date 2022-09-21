package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import io.javalin.http.UploadedFile;
import my.contacts.database.hibernate.dao.ContactDAO;
import my.contacts.models.Contact;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.InputStream;

public class EditPhotoHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int contact_id = Integer.parseInt(context.pathParam("contact_id"));
        Contact contact = ContactDAO.get(contact_id);
        UploadedFile photo = context.uploadedFile("new_photo");
        if((photo.getFilename() != null) && !(photo.getFilename().equals(""))){
            String new_photo = photo.getFilename();
            InputStream is = photo.getContent();
            File images_file = new File(System.getenv("JAVA_RESOURCES") + "/my_contacts/static/contacts_images/" + new_photo);
            FileUtils.copyInputStreamToFile(is, images_file);
            contact.setPhoto(new_photo);
            if(ContactDAO.edit(contact)> 0 ){
                context.redirect("/?EditContact=true");
            }else {
                context.redirect("/?EditContact=true");
            }
        }
    }
}
