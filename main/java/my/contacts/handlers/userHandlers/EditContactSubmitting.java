package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.ContactDAO;
import my.contacts.models.Contact;


public class EditContactSubmitting implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String new_first_name = context.formParam("first_name");
        String new_last_name = context.formParam("last_name");
        String new_phone = context.formParam("phone");
        int contact_id = Integer.parseInt(context.pathParam("contact_id"));
        Contact contact = ContactDAO.get(contact_id);
        contact.setFirst_name(new_first_name);
        contact.setLast_name(new_last_name);
        contact.setPhone(new_phone);
        if(ContactDAO.edit(contact) > 0){
            context.redirect("/?EditContact=true");
        }else {
            context.redirect("/?EditContact=false");
        }
    }
}
