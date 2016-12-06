package module6;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * The class provides getAddressInMemory method.
 * Address in memory may change as JVM works, so this information is useless for enterprise.
 */
public class UnsafeUtil {
    private UnsafeUtil(){}

    public static Unsafe unsafe;
    private static long fieldOffset;
    private static UnsafeUtil instance = new UnsafeUtil();

    private Object obj;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);

            unsafe = (Unsafe)f.get(null);
            fieldOffset = unsafe.objectFieldOffset(UnsafeUtil.class.getDeclaredField("obj"));
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static long getAddressInMemory (Object o){
        instance.obj = o;
        return unsafe.getLong(instance, fieldOffset);
    }
}