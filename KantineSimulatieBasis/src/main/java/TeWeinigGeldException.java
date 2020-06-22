import org.postgresql.translation.messages_bg;

public class TeWeinigGeldException extends Exception {

    /**
     * constructors
     */
    TeWeinigGeldException() {
        super();
    }

    TeWeinigGeldException(Exception e) {
        super(e);
    }

    TeWeinigGeldException(String msg) {
        super(msg);
    }

}