package my.contacts.handlers.loginHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.templating.Renderer;

public class RegisterHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String html_content = Renderer.render("register.ftl");
        context.html(html_content);
    }
}
