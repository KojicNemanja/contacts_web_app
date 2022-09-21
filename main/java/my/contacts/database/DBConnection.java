package my.contacts.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection conn = null;

    public static Connection get() throws SQLException {
        if(conn != null) return conn;
        DBConfiguration dbConfiguration = DatabaseFileUtil.get();
        StringBuilder connection_url = new StringBuilder("jdbc:mysql://localhost:");
        connection_url.append(dbConfiguration.getHost() + "/");
        connection_url.append(dbConfiguration.getDatabase());
        String password = dbConfiguration.getPassword().substring(32);
        return DriverManager.getConnection(connection_url.toString(), dbConfiguration.getUsername(), password);
    }
}