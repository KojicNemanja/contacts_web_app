package my.contacts.handlers.loginHandlers;

import io.javalin.http.Context;
import io.javalin.http.Handler;
import my.contacts.database.hibernate.dao.UserDAO;
import my.contacts.models.User;
import my.contacts.utils.HashUtil;

public class RegisterSubmittingHandler implements Handler {
    @Override
    public void handle(Context context) throws Exception {
        String first_name = context.formParam("first_name");
        String last_name = context.formParam("last_name");
        String username = context.formParam("username");
        String password = context.formParam("password");

        User user = new User(null, first_name, last_name, username, HashUtil.passwordToHash(password));
        int generated_id = UserDAO.save(user);
        if(generated_id> 0){
            context.redirect("/login?RegisterUser=true");
        }else {
            context.redirect("/login?RegisterUser=false");
        }
    }
}
