package my.contacts.database;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DatabaseFileUtil {
    private static DBConfiguration dbConfiguration = null;

    public static DBConfiguration get(){
        if(dbConfiguration != null) return dbConfiguration;
        try {
            Gson gson = new Gson();
            String database_file_path = System.getenv("JAVA_RESOURCES") + "/my_contacts/database/db_config.json";
            FileReader reader = new FileReader(new File(database_file_path));
            dbConfiguration = gson.fromJson(reader, DBConfiguration.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        return dbConfiguration;
    }
}
