package Task60150;

import java.io.Serializable;

public enum MessageType implements Serializable {
    NAME_REQUEST,
    USER_NAME,
    NAME_ACCEPTED,
    TEXT,
    USER_ADDED,
    USER_REMOVED
}
