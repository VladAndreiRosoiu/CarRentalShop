package ro.var.rentalshop.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class DBConnection {

    private final File PROPERTIES_FILE = new File(Objects.requireNonNull(
            DBConnection.class.getClassLoader().getResource("db.properties")).getFile());

    private Properties getDBProperties() throws IOException {
        Properties properties = new Properties();
        InputStream input = new FileInputStream(PROPERTIES_FILE);
        properties.load(input);
        return properties;
    }

    public Connection getConnection() throws IOException, SQLException {
        return DriverManager.getConnection("jdbc:mysql://" +
                        getDBProperties().getProperty("serverURL") + ":" + getDBProperties().getProperty("serverPort") + "/" +
                        getDBProperties().getProperty("database") + "?serverTimezone=UTC",
                getDBProperties().getProperty("user"),
                getDBProperties().getProperty("password"));
    }

}
