package mysql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public final class PropertiesUtil {

    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        File propertiesFile = Paths.get("resources", "application.properties").toFile();
        try {
            PROPERTIES.load(new BufferedReader(new FileReader(propertiesFile)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private PropertiesUtil() {
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
