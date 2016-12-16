package module7.Task_1_3;

import java.util.UUID;

/**
 * Created by g.zubenko on 11.12.2016.
 */
interface IdProvider {
    long getNewId();
}

final class UuidProvider implements IdProvider{
    private static UuidProvider instance;
    private UuidProvider(){}

    public long getNewId()
    {
        return -(UUID.randomUUID().getLeastSignificantBits());
    }

    static public UuidProvider getInstance(){
        if (instance==null) instance=new UuidProvider();
        return  instance;
    }
}
