package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.ContactDAO;
import my.contacts.models.Contact;

public class DeletePhotoHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int contact_id = Integer.parseInt(context.pathParam("contact_id"));
        Contact contact = ContactDAO.get(contact_id);
        contact.setPhoto("");
        if(ContactDAO.edit(contact) > 0){
            context.redirect("/?EditContact=true");
        }else {
            context.redirect("/?EditContact=false");
        }
    }
}
