package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.ContactDAO;
import my.contacts.models.Contact;
import my.contacts.templating.Renderer;

import java.util.HashMap;

public class EditContactHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        int contact_id = Integer.parseInt(context.pathParam("contact_id"));
        Contact contact = ContactDAO.get(contact_id);
        HashMap<String, Object> model_data = new HashMap<>();
        model_data.put("contact", contact);
        String html_content = Renderer.render("edit{contact_id}.ftl", model_data);
        context.html(html_content);
    }
}
