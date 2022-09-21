package my.contacts.handlers.loginHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.templating.Renderer;

import java.util.HashMap;

public class LoginHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        HashMap<String, Object> model_data = new HashMap<>();
        if(context.queryParam("Login") != null){
            model_data.put("Login", context.queryParam("Login"));
        }
        String html_content = Renderer.render("login.ftl", model_data);
        context.html(html_content);
    }
}
