package coral.co.coralin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgehernandez on 4/17/16.
 */
public class IN_state {
    private String code;
    private List<String> messages;

    public IN_state(String code, List<String> messages) {
        this.code = code;
        this.messages = messages;
    }

    public IN_state() {
        this.code = "";
        this.messages = new ArrayList<String>();

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }
}
