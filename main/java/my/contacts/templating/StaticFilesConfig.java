package my.contacts.templating;

import io.javalin.http.staticfiles.Location;

import java.util.function.Consumer;

public class StaticFilesConfig implements Consumer<io.javalin.core.JavalinConfig> {
    @Override
    public void accept(io.javalin.core.JavalinConfig javalinConfig) {
        String static_file_path = System.getenv("JAVA_RESOURCES") + "/my_contacts/static/";
        javalinConfig.addStaticFiles(static_file_path, Location.EXTERNAL);
    }
}
