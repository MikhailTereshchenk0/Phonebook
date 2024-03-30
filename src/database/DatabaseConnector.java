//singleton

package database;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    private static DatabaseConnector instance;
    private Connection connection;

    private DatabaseConnector() {
        try {
            /*ResourceBundle resource = ResourceBundle.getBundle("database.properties");
            String URL = resource.getString("URL");
            String user = resource.getString("user");
            String password = resource.getString("password");*/

            Properties properties = new Properties();
            try (InputStream in = Files.newInputStream(Paths.get("/Users/mikhail/Documents/IdeaProjects/phonebook/src/database/database.properties"))) {
                properties.load(in);
            }
            String URL = properties.getProperty("URL");

            this.connection = DriverManager.getConnection(URL, properties);
        }
        catch(SQLException | IOException exception) {
            exception.printStackTrace();
        }
    }

    public static DatabaseConnector getInstance() {
        if (instance == null) {
            instance = new DatabaseConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
