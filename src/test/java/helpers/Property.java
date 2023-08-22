package helpers;

import java.io.InputStream;
import java.util.Properties;

public class Property {

    private static final Properties property;

    static {
        property = new Properties();

        try (InputStream is = Property.class.getResourceAsStream("/test.properties")) {
            property.load(is);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String get(String parameter) {
        return property.getProperty(parameter);
    }
}
