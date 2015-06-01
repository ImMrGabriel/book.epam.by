package resource;

import java.util.ResourceBundle;

/**
 * The class extracts information from resource/messages.properties
 */
public class MessageManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

    private MessageManager() {}

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
