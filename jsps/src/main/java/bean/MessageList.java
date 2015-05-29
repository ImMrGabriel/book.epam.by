package bean;

import java.util.ArrayList;

public class MessageList extends ArrayList<Message> {
    {
        add(new Message(1, "hello!"));
        add(new Message(2, "mid"));
        add(new Message(3, "bye!"));
    }

    public MessageList() {
    }
}
