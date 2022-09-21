package my.contacts;

import io.javalin.Javalin;
import my.contacts.handlers.*;
import my.contacts.handlers.loginHandlers.LoginHandler;
import my.contacts.handlers.loginHandlers.LoginSubmitting;
import my.contacts.handlers.loginHandlers.RegisterHandler;
import my.contacts.handlers.loginHandlers.RegisterSubmittingHandler;
import my.contacts.handlers.userHandlers.*;
import my.contacts.handlers.userHandlers.AddContactSubmittingHandler;
import my.contacts.handlers.userHandlers.EditContactSubmitting;
import my.contacts.templating.StaticFilesConfig;

public class Program {
    public static void main(String[] args) {
        Javalin app = Javalin.create(new StaticFilesConfig());

        app.before(new BeforeHandler());

        app.get("/login", new LoginHandler());
        app.post("/login", new LoginSubmitting());
        app.get("/register", new RegisterHandler());
        app.post("/register", new RegisterSubmittingHandler());

        app.get("/", new HomeHandler());
        app.get("/add_contact", new AddContactHandler());
        app.post("/add_contact", new AddContactSubmittingHandler());
        app.get("/edit/{contact_id}", new EditContactHandler());
        app.post("/edit/{contact_id}", new EditContactSubmitting());
        app.get("/delete/{contact_id}", new DeleteContactHandler());
        app.get("/delete_photo/{contact_id}", new DeletePhotoHandler());
        app.post("/add_photo/{contact_id}", new AddPhotoContactHandler());
        app.post("/uploaded_photo/{contact_id}", new EditPhotoHandler());
        app.get("/logout", new LogoutHandler());

        app.start(9090);
    }
}
