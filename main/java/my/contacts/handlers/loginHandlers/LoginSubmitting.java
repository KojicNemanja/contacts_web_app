package my.contacts.handlers.loginHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.UserDAO;
import my.contacts.models.User;
import my.contacts.utils.HashUtil;

public class LoginSubmitting implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String user_name = context.formParam("username");
        User user = UserDAO.getForUsername(user_name);
        if(user != null){
            String password = context.formParam("password");
            if(user.getPassword().equals(HashUtil.passwordToHash(password))){
                context.sessionAttribute("user", user);
                context.redirect("/");
                return;
            }
        }
        context.redirect("/login?Login=false");
    }
}
