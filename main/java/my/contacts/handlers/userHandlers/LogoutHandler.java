package my.contacts.handlers.userHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class LogoutHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        context.consumeSessionAttribute("user");
        context.redirect("/login");
    }
}
