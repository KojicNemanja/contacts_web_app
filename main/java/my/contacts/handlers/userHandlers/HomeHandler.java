package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.ContactDAO;
import my.contacts.models.User;
import my.contacts.templating.Renderer;

import java.util.HashMap;

public class HomeHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> model_data = new HashMap<>();
        User user = (User) context.sessionAttribute("user");

        String saveContact = context.queryParam("SaveContact");
        String editContact = context.queryParam("EditContact");
        String deleteContact = context.queryParam("DeleteContact");
        String phrase = context.queryParam("phrase");

        if(saveContact != null){
            model_data.put("SaveContact", saveContact);
        }
        if(editContact != null){
            model_data.put("EditContact", editContact);
        }
        if (deleteContact != null){
            model_data.put("DeleteContact", deleteContact);
        }
        if(phrase != null){
            model_data.put("contacts", ContactDAO.getForPhrase(user.getUser_id(), phrase));
        }else {
            model_data.put("contacts", ContactDAO.getAll(user.getUser_id()));
        }
        String html_content = Renderer.render("home.ftl", model_data);
        context.html(html_content);
    }
}
