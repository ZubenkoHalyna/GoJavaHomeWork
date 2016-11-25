package module5.api;

import java.util.UUID;

/**
 * Created by g.zubenko on 23.11.2016.
 */
class IdProvider {
    static public long getNewId() {
        return (UUID.randomUUID().getLeastSignificantBits());
    }
}
