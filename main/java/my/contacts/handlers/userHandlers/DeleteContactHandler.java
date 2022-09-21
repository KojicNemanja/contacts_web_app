package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.ContactDAO;

public class DeleteContactHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int contact_id = Integer.parseInt(context.pathParam("contact_id"));
        int result = ContactDAO.delete(contact_id);
        if (result > 0){
            context.redirect("/?DeleteContact=true");
        }else {
            context.redirect("/?DeleteContact=false");
        }
    }
}
