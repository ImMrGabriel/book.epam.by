package resource;

import java.util.ResourceBundle;

/**
 * The Class extracts information from resource/config.properties
 */
public class ConfigurationManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    private ConfigurationManager() {}

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
