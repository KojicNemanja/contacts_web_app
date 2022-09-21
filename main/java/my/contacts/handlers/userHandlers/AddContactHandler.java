package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.templating.Renderer;

public class AddContactHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String html_content = Renderer.render("add_contact.ftl");
        context.html(html_content);
    }
}
