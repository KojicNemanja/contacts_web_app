package my.contacts.handlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class BeforeHandler implements Handler {

    @Override
    public void handle(Context context) throws Exception {
        if(!(context.path().equals("/login") || context.path().equals("/register")
                || context.path().equals("/css/style.css")  ||
                context.path().equals("/css/media_style.css"))){
            if(context.sessionAttribute("user") == null){
                context.redirect("/login");
            }
        }
    }
}
