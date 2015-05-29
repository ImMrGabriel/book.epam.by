package bean;

import java.util.HashMap;

public class MessageMap extends HashMap<String, Message> {
    {
        put("Gabriel", new Message(1, "Work"));
        put("Jukov", new Message(23, "Holiday"));
    }
}
